package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * @author wuss.
 * @date 2018/12/13 20:03
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String userId,String orderId);
    //取消订单
    OrderDTO cancelOrder(String userId, String orderId);
}
