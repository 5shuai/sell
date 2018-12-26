package com.imooc.form;

import com.imooc.dto.ProductInfoDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;
    /**
     * 买家收货地址
     */
    @NotEmpty(message = "地址必填")
    private String address;
    /**
     * 买家userId
     */
    @NotEmpty(message = "userId必填")
    private String userId;
    /**
     * 买家购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private List<ProductInfoDTO> items;
}