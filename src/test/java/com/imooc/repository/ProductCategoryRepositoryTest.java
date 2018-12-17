package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Ignore
    public void findOneTest() {
        ProductCategory productCategory = repository.findById(3).orElse(null);
        if (null != productCategory) {
            log.info(productCategory.toString());
            System.out.println(productCategory.toString());
        }
    }

    @Test
    @Ignore
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("主食");
        productCategory.setCategoryType(1);
        repository.save(productCategory);
    }

    @Test
    @Ignore
    public void updateTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男女生都最爱");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    @Test
    @Ignore
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2,3);
        List<ProductCategory> productCategories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategories.size());


    }
}