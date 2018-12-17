package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuss.
 * @date 2018/12/14 11:25
 */

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("auth")
    public void auth(){
//        log.info();
    }
}