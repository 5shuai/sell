package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110111110";

    @Test
    @Ignore
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDTO.setBuyerAddress("测试卖家地址");
        orderDTO.setBuyerName("测试姓名");
        orderDTO.setBuyerPhone("13655555555");
        orderDTO.setBuyerId(BUYER_OPENID);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("56431346");
        orderDetail.setProductQuantity(2);
        orderDetails.add(orderDetail);

        orderDTO.setOrderDetails(orderDetails);
        log.info("orderDetails为{}", orderDetails);

        OrderDTO result = orderService.create(orderDTO);

        log.info("result为{}", result);
        Assert.assertNotNull(result);
    }

    @Test
    @Ignore
    public void findOne(){
        OrderDTO orderDTO = orderService.findOne("1544508515845703669");
        Assert.assertNotNull(orderDTO);
    }

    @Test
    @Ignore
    public void findList(){
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList("fwaekfjawklefjaw",request);
        Assert.assertEquals(1,orderDTOPage.getTotalElements());
    }

    @Test
    @Ignore
    public void list(){
        PageRequest request = PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        Assert.assertEquals(1,orderDTOPage.getTotalElements());
    }
}