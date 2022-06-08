package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Manager;

public interface IManagerService extends IService<Manager> {
    PageInfo<Manager> findManagerAll(int page, int pageSize, String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Manager>
     */
    IPage<Manager> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param manager
     * @return int
     */
    int add(Manager manager);

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
     * @param manager
     * @return int
     */
    int updateData(Manager manager);

    /**
     * id查询数据
     *
     * @param id id
     * @return Manager
     */
    Manager findById(Long id);

    Manager queryManagerById(Integer managerId);
}
