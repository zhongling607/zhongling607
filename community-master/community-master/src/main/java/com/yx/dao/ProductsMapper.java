package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Products;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("productsDao")
public interface ProductsMapper   extends BaseMapper<Products> {
    List<Products> queryProductsAll(@Param("numbers") String numbers);
    /**
     * 通过products中products_id查找products
     */
    Products queryProductsById(@Param("productsId") Integer productsId);
}
