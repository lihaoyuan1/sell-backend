package com.lhy.sell.Mapper;

import com.lhy.sell.Entity.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {

    @Select("select * from product_category")
    List<ProductCategory> getAll();

    @Select("select * from product_category where category_id = #{id}")
    ProductCategory getOne(@Param("id") Integer id);

    @Insert("insert into product_category (category_name, category_type) values(#{categoryName},#{categoryType})")
    Integer save(ProductCategory productCategory);

    @Select("<script>select * from product_category where category_type in <foreach item='item' index='index' collection='typeList' open='(' separator=',' close=')'> #{item} </foreach></script>")
    List<ProductCategory> findByCategoryTypeIn(@Param("typeList") List<Integer> typeList);
}
