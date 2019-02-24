package com.lhy.sell.Service;

import com.github.pagehelper.PageInfo;
import com.lhy.sell.Entity.ProductInfo;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    PageInfo<ProductInfo> findAll(Integer currentPage, Integer pageSize);

    List<ProductInfo> findUpAll();

    Integer save(ProductInfo productInfo);

    //加库存

    //减库存
}
