package com.imooc.controller;

import com.imooc.dataobject.ProductCategory;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(categoryId)) {
            ProductCategory category = categoryService.findById(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        try {
            ProductCategory category = new ProductCategory();
            if (!StringUtils.isEmpty(form.getCategoryId())) {
                category = categoryService.findById(form.getCategoryId());
                BeanUtils.copyProperties(form, category);
            } else {
                BeanUtils.copyProperties(form, category);
                List<ProductCategory> categoryList = categoryService.findAll();
                List<Integer> categoryTypeList = categoryList.stream().map(ProductCategory::getCategoryType).collect(Collectors.toList());
                if (categoryTypeList.contains(category.getCategoryType())) {
                    log.error("【商品类型】已存在");
                    throw new SellException(ResultEnum.CATEGORY_TYPE_EXIST);
                }
            }
            categoryService.save(category);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }

}
