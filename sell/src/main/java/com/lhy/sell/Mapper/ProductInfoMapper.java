package com.lhy.sell.Mapper;

import com.lhy.sell.Entity.ProductInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductInfoMapper {

    @Select("select * from product_info where product_status = #{status}")
    List<ProductInfo> findByProductStatus(@Param("status") Integer productStatus);

    @Insert("insert into product_info (product_id, product_name, product_price, product_stock, product_describe, product_icon, product_status, category_type) values(#{productId}, #{productName}, #{productPrice}, #{productStock}, #{productDescribe}, #{productIcon}, #{productStatus}, #{categoryType})")
    Integer save(ProductInfo productInfo);

    @Select("select * from product_info where product_id = #{id}")
    ProductInfo getOne(@Param("id") String id);

    @Select("select * from product_info")
    List<ProductInfo> getAll();
}
