package com.imooc.handler;

import com.imooc.exception.SellerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {
    //拦截登录异常

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("user/loginPage");
    }
}
