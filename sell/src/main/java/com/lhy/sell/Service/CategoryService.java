package com.lhy.sell.Service;

import com.lhy.sell.Entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    Integer save(ProductCategory productCategory);
}
