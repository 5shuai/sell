package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wuss.
 * @date 2018/12/20 15:01
 */
@Data
public class ProductForm {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
}
