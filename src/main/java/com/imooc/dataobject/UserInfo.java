package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/**
 * @author wuss.
 * @date 2018/12/21 11:28
 */

@Data
@Entity
@DynamicUpdate
public class UserInfo {
    @Id
    private String userId;
    private String username;
    private String password;
}