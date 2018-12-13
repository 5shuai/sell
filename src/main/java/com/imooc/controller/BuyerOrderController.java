package com.imooc.controller;

import com.imooc.VO.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/buyer/order")
@Slf4j
public class BuyerOrderController {
    //创建订单
    @RequestMapping(value = "/create")
    public ResultVO<Map<String,String>> create(){
        return null;
    }
    //订单列表

    //订单详情

    //取消订单
}
