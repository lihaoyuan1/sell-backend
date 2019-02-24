package com.lhy.sell.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhy.sell.Entity.ProductInfo;
import com.lhy.sell.Enums.ProductStatusEnum;
import com.lhy.sell.Mapper.ProductInfoMapper;
import com.lhy.sell.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoMapper.getOne(productId);
    }

    @Override
    public PageInfo<ProductInfo> findAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<ProductInfo> list = productInfoMapper.getAll();
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list, pageSize);
        return pageInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoMapper.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Integer save(ProductInfo productInfo) {
        return productInfoMapper.save(productInfo);
    }
}
