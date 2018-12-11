package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl service;

    @Test
    @Ignore
    public void findById() {
        ProductCategory category = service.findById(1);
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    @Ignore
    public void findAll() {
        List<ProductCategory> categories = service.findAll();
        Assert.assertEquals(3, categories.size());
    }

    @Test
    @Ignore
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> categories = service.findByCategoryTypeIn(list);
        Assert.assertEquals(3, categories.size());
    }

    @Test
    @Transactional
    @Ignore
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(4);
        productCategory.setCategoryName("男生最爱");
        service.save(productCategory);
    }
}