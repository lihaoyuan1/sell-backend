package com.lhy.sell.Mapper;

import com.lhy.sell.Entity.ProductInfo;
import com.lhy.sell.Enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoMapperTest {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void findByProductStatus() {
        System.out.println(productInfoMapper.findByProductStatus(ProductStatusEnum.UP.getCode()));
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescribe("很好吃的吓");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        productInfoMapper.save(productInfo);
    }
}
