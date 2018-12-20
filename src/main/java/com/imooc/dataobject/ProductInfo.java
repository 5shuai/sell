package com.imooc.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    private Integer categoryType;
    private Date createTime;
    private Date updatedTime;

    public ProductInfo(){}

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getBycode(productStatus,ProductStatusEnum.class);
    }
}
