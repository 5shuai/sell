package com.imooc.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 具体内容
     */
    private T data;
}
