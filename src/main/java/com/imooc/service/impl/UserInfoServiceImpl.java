package com.imooc.service.impl;

import com.imooc.dataobject.UserInfo;
import com.imooc.repository.UserInfoRepository;
import com.imooc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserInfo findPasswordByName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<UserInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }
}
