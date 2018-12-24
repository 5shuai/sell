package com.imooc.service;

import com.imooc.dataobject.UserInfo;

import java.util.List;

/**
 * @author wuss.
 * @date 2018/12/21 12:56
 */
public interface UserInfoService {
    UserInfo findPasswordByName(String username);
    UserInfo save(UserInfo userInfo);
    List<UserInfo> findAll();
}