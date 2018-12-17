package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    @Ignore
    public void findByOrderId() {
        List<OrderDetail> orderDetails = repository.findByOrderId("123");
        Assert.assertEquals(1,orderDetails.size());
    }

    @Test
    @Ignore
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("56431346");
        orderDetail.setProductName("土豆丝");
        orderDetail.setProductPrice(new BigDecimal(6.86));
        orderDetail.setProductQuantity(2);
        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotNull(detail);
    }
}