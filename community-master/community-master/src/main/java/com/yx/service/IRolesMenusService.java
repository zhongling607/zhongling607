package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.RolesMenus;

public interface IRolesMenusService extends IService<RolesMenus> {
    PageInfo<RolesMenus> findRolesMenusAll(int page, int pageSize, String rolesId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<RolesMenus>
     */
    IPage<RolesMenus> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param rolesMenus
     * @return int
     */
    int add(RolesMenus rolesMenus);

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
     * @param rolesMenus
     * @return int
     */
    int updateData(RolesMenus rolesMenus);

    /**
     * id查询数据
     *
     * @param id id
     * @return RolesMenus
     */
    RolesMenus findById(Long id);

    RolesMenus queryRolesMenusById(Integer rolesMenusId);
}
