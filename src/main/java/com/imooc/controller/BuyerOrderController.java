package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "/buyer/order")
@Slf4j
public class BuyerOrderController {
    //创建订单

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping(value = "/create")
    public ResultVO create(@RequestBody @Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping(value = "/list")
    public ResultVO list(@RequestParam("userId") String userId,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(userId)) {
            log.error("【查询订单列表】userId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(userId, request);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping(value = "/detail")
    public ResultVO detail(@RequestParam("userId") String userId,
                           @RequestParam("orderId") String orderId) {

        OrderDTO orderDTO = buyerService.findOrderOne(userId, orderId);
        return ResultVOUtil.success(orderDTO);

    }

    //取消订单
    @PostMapping(value = "/cancel")
    public ResultVO cancel(@RequestParam("userId") String userId,
                           @RequestParam("orderId") String orderId) {
        //TODO 不安全的改进
        buyerService.cancelOrder(userId, orderId);
        return ResultVOUtil.success();
    }

    //支付订单
    @PostMapping(value = "/paid")
    public ResultVO paid(@RequestParam("userId") String userId,
                         @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(userId, orderId);
        orderService.paid(orderDTO);
        return ResultVOUtil.success();
    }
}