package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * @author wuss.
 * @date 2018/12/21 12:56
 */
public interface SellerService {
    SellerInfo findSellerInfoByOpenid(String openid);
}
