package com.lhy.sell.ViewObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductVo {

    @JsonProperty("name")
    private String category_name;

    @JsonProperty("type")
    private Integer category_type;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getCategory_type() {
        return category_type;
    }

    public void setCategory_type(Integer category_type) {
        this.category_type = category_type;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }
}
