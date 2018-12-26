package com.imooc.controller;


import com.imooc.config.UserConfig;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.UserInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.UserRegisterForm;
import com.imooc.service.UserInfoService;
import com.imooc.utils.CookieUtil;
import com.imooc.utils.EncrypDESUtil;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/register")
    public ModelAndView register(@Valid UserRegisterForm userForm,
                                 BindingResult bindingResult,
                                 Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        List<UserInfo> userInfoList = userInfoService.findAll();
        if (userInfoList != null) {
            try {

                List<String> userList = userInfoList.stream().map(UserInfo::getUsername).collect(Collectors.toList());
                if (userList.contains(userForm.getRegisterUserName())) {
                    log.error("【用户注册】错误，用户 [{}] 已存在，请更换用户名", userForm.getRegisterUserName());
                    throw new SellException(ResultEnum.USER_EXIST);
                }
            } catch (SellException e) {
                map.put("msg", e.getMessage());
                map.put("url", "login_page");
                return new ModelAndView("common/error", map);
            }
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setUsername(userForm.getRegisterUserName());
        String password = EncrypDESUtil.encode3Des(UserConfig.key, userForm.getRegisterUsePassword());
        userInfo.setPassword(password);
        userInfoService.save(userInfo);
        map.put("url", "login_page");
        return new ModelAndView("common/registerSuccess", map);
    }

    @RequestMapping("/login_page")
    public ModelAndView loginPage() {
        return new ModelAndView("user/loginPage");
    }

    @PostMapping("/login")
    public ModelAndView login(UserInfo userInfo,
                              HttpServletResponse response,
                              Map<String, Object> map) {
        if (userInfo != null) {
            try {
                UserInfo userInfo1 = userInfoService.findPasswordByName(userInfo.getUsername());
                if (userInfo1 == null) {
                    log.error("【用户登录】，用户 [{}] 不存在", userInfo.getUsername());
                    throw new SellException(ResultEnum.USER_NOT_EXIST);
                } else {
                    String password = EncrypDESUtil.encode3Des(UserConfig.key, userInfo.getPassword());
                    if (!userInfo1.getPassword().equals(password)) {
                        log.error("【用户登录】，用户 [{}] 密码不正确", userInfo.getUsername());
                        throw new SellException(ResultEnum.USER_PASSWORD_INCORRECT);
                    }
                }
            } catch (SellException e) {
                map.put("msg", e.getMessage());
                map.put("url", "login_page");
                return new ModelAndView("common/error", map);
            }
        }
//        设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), token, expire, TimeUnit.SECONDS);
//        设置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return new ModelAndView("redirect:/seller/order/list");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response) {
        //1.从cookie里面查询，清除
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        return new ModelAndView("user/loginPage");
    }
}
