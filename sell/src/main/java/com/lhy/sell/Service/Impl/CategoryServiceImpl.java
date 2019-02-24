package com.lhy.sell.Service.Impl;

import com.lhy.sell.Entity.ProductCategory;
import com.lhy.sell.Mapper.ProductCategoryMapper;
import com.lhy.sell.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryMapper categoryMapper;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryMapper.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryMapper.getAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryMapper.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public Integer save(ProductCategory productCategory) {
        return categoryMapper.save(productCategory);
    }
}
