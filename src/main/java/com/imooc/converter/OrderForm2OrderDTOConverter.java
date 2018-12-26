package com.imooc.converter;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.dto.ProductInfoDTO;
import com.imooc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuss.
 * @date 2018/12/13 12:58
 */

@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
//        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerId(orderForm.getUserId());
        List<OrderDetail> orderDetailList = new ArrayList<>();
//        try {
//            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
//            }.getType());
//        }catch (Exception e){
//            log.error("【对象转换】错误，string={}",orderForm.getItems());
//            throw new SellException(ResultEnum.PARAM_ERROR);
//        }

        for (ProductInfoDTO productInfoDTO : orderForm.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductQuantity(productInfoDTO.getProductQuantity());
            orderDetail.setProductId(productInfoDTO.getProductId());
            orderDetailList.add(orderDetail);
        }
        orderDTO.setOrderDetails(orderDetailList);
        return orderDTO;
    }
}
