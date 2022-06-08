package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ProductsMapper;
import com.yx.model.Products;
import com.yx.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductsServiceImpl   extends ServiceImpl<ProductsMapper, Products> implements IProductsService {
    @Autowired
    private ProductsMapper
            productsDao;
    @Override
    public PageInfo<Products> findProductsAll(int page, int pageSize, String numbers) {
        PageHelper.startPage(page,pageSize);
        List<Products>
                list=productsDao.queryProductsAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Products> findListByPage(Integer page, Integer pageCount){
        IPage<Products> wherePage = new Page<>(page, pageCount);
        Products
                where = new Products();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Products products){
        return baseMapper.insert(products);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Products products){
        return baseMapper.updateById(products);
    }

    @Override
    public Products findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Products queryProductsById(Integer productsId) {
        return productsDao.queryProductsById(productsId);
    }

}
