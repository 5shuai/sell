package com.imooc.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态异常"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态错误"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    PRODUCT_STATUS_ERROR(20, "商品状态不正确"),
    PRODUCT_ON_SALE_SUCCESS(21, "商品上架成功"),
    PRODUCT_OFF_SALE_SUCCESS(22, "商品下架成功"),
    CATEGORY_TYPE_EXIST(23, "商品类型已存在"),
    USER_EXIST(24, "用户已存在"),
    USER_NOT_EXIST(25, "用户不存在"),
    USER_PASSWORD_INCORRECT(26, "密码错误"),
    ORDER_CANCEL_SUCCESS(2, "订单取消成功"),
    ORDER_FINISH_SUCCESS(3, "订单完结成功");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
