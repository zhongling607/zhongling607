package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Executing;

public interface IExecutingService  extends IService<Executing> {
    PageInfo<Executing> findExecutingAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Executing>
     */
    IPage<Executing> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param executing
     * @return int
     */
    int add(Executing executing);

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
     * @param executing
     * @return int
     */
    int updateData(Executing executing);

    /**
     * id查询数据
     *
     * @param id id
     * @return Executing
     */
    Executing findById(Long id);

    Executing queryExecutingById(Integer executingId);
}
