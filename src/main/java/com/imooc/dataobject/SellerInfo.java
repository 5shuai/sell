package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author wuss.
 * @date 2018/12/21 11:28
 */

@Data
@Entity
@DynamicUpdate
public class SellerInfo {
    @Id
    private String sellerId;
    private String userName;
    private String password;
    private String openid;
}
