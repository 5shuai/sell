package com.imooc.repository;

import com.imooc.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    UserInfo findByUsername(String username);
}