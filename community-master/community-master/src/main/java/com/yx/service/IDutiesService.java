package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Duties;

public interface IDutiesService  extends IService<Duties> {
    PageInfo<Duties> findDutiesAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Duties>
     */
    IPage<Duties> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param duties
     * @return int
     */
    int add(Duties duties);

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
     * @param duties
     * @return int
     */
    int updateData(Duties duties);

    /**
     * id查询数据
     *
     * @param id id
     * @return Duties
     */
    Duties findById(Long id);

    Duties queryDutiesById(Integer dutiesId);
}
