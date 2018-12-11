package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;
    @Test
    @Ignore
    public void saveProductInfo() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("56431345");
        productInfo.setProductDescription("这是一个测试的商品");
        productInfo.setProductIcon("这个是一个小图");
        productInfo.setProductName("皮蛋瘦肉粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductStatus(1);
        productInfo.setCategoryType(1);
        ProductInfo productInfo1 = repository.save(productInfo);
        Assert.assertEquals("56431345",productInfo1.getProductId());
    }

    @Test
    @Ignore
    public void FindByProductStatus(){
        List<ProductInfo> productInfos = repository.findByProductStatus(1);
        Assert.assertEquals(1,productInfos.size());
    }

}