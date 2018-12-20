package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl service;

    @Test
    @Ignore
    public void findOne() {
        ProductInfo productInfo = service.findOne("56431345");
        Assert.assertNotNull(productInfo);
    }

    @Test
    @Ignore
    public void findUpAll() {
        List<ProductInfo> productInfos = service.findUpAll();
        Assert.assertEquals(1, productInfos.size());
    }

    @Test
    @Ignore
    public void findAll() {
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfos = service.findAll(request);
        System.out.println(productInfos);

    }

    @Test
    @Ignore
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("56431312");
        productInfo.setProductDescription("这是一个测试的商品");
        productInfo.setProductIcon("这个是一个小图");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        service.save(productInfo);
    }

    @Test
    @Ignore
    public void onSale(){
        ProductInfo productInfo = service.onSale("56431345");
        Assert.assertEquals(Integer.valueOf(0),productInfo.getProductStatus());
    }

    @Test
    @Ignore
    public void offSale(){
        ProductInfo productInfo = service.offSale("56431345");
        Assert.assertEquals(Integer.valueOf(1),productInfo.getProductStatus());
    }
}