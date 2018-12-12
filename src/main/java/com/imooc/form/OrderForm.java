package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;
}
