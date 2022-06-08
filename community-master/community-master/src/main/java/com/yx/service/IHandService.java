package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Hand;

public interface IHandService extends IService<Hand> {
    PageInfo<Hand> findHandAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Hand>
     */
    IPage<Hand> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param hand
     * @return int
     */
    int add(Hand hand);

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
     * @param hand
     * @return int
     */
    int updateData(Hand hand);

    /**
     * id查询数据
     *
     * @param id id
     * @return Hand
     */
    Hand findById(Long id);

    Hand queryHandById(Integer handId);
}
