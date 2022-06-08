package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Roles;

public interface IRolesService extends IService<Roles> {
    PageInfo<Roles> findRolesAll(int page, int pageSize, String rolesName);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Roles>
     */
    IPage<Roles> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param roles
     * @return int
     */
    int add(Roles roles);

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
     * @param roles
     * @return int
     */
    int updateData(Roles roles);

    /**
     * id查询数据
     *
     * @param id id
     * @return Roles
     */
    Roles findById(Long id);

    Roles queryRolesById(Integer rolesId);
}
