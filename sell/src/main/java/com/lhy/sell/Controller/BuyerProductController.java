package com.lhy.sell.Controller;

import com.lhy.sell.Entity.ProductCategory;
import com.lhy.sell.Entity.ProductInfo;
import com.lhy.sell.Service.CategoryService;
import com.lhy.sell.Service.ProductService;
import com.lhy.sell.Utils.ResultVoUtil;
import com.lhy.sell.ViewObject.ProductInfoVo;
import com.lhy.sell.ViewObject.ProductVo;
import com.lhy.sell.ViewObject.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目（一次性查询）
        List<Integer> categoryList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList){
            categoryList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        //数据拼装
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategory_type(productCategory.getCategoryType());
            productVo.setCategory_name(productCategory.getCategoryName());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }

        return ResultVoUtil.success(productVoList);
    }
}
