package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;
import org.junit.Assert;
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
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("1212121212");
        sellerInfo.setUserName("测试");
        sellerInfo.setPassword("121212");
        sellerInfo.setSellerId("121212");
        repository.save(sellerInfo);
    }

    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("1212121212");
        Assert.assertEquals("测试", sellerInfo.getUserName());

    }
}