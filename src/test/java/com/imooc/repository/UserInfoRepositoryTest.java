package com.imooc.repository;

import com.imooc.dataobject.UserInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wuss.
 * @date 2018/12/21 11:31
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    @Ignore
    public void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("123456");
        userInfo.setUsername("测试");
        repository.save(userInfo);
    }

    @Test
    @Ignore
    public void findByOpenid() {
        UserInfo userInfo = repository.findByUsername("测试");
        Assert.assertEquals("123456",userInfo.getPassword());
    }
}