package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    @Ignore
    public void findByBuyerId() {
        PageRequest request = PageRequest.of(0,2);
        Page<OrderMaster> masterPages = repository.findByBuyerId("2233",request);
        System.out.println(masterPages);
    }

    @Test
    @Ignore
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("环科路");
        orderMaster.setBuyerName("wuss");
        orderMaster.setBuyerId("2fda0aeb-da73-4ef4-b4ef-3b20e98a2203");
        orderMaster.setBuyerPhone("15613219283");
        orderMaster.setOrderAmount(new BigDecimal(15.66));
        orderMaster.setOrderId(KeyUtil.genUniqueKey());
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}