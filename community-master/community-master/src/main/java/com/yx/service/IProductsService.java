package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Products;

public interface IProductsService  extends IService<Products> {
    PageInfo<Products> findProductsAll(int page, int pageSize, String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Products>
     */
    IPage<Products> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param products
     * @return int
     */
    int add(Products products);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param products
     * @return int
     */
    int updateData(Products products);

    /**
     * id查询数据
     *
     * @param id id
     * @return Products
     */
    Products findById(Long id);

    Products queryProductsById(Integer productsId);
}
