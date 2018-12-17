package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @author wuss.
 * @date 2018/12/17 18:08
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getBycode(Integer code , Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
