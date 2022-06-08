package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.UserRoles;

public interface IUserRolesService  extends IService<UserRoles> {
    PageInfo<UserRoles> findUserRolesAll(int page, int pageSize, String username);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<UserRoles>
     */
    IPage<UserRoles> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param userRoles
     * @return int
     */
    int add(UserRoles userRoles);

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
     * @param userRoles
     * @return int
     */
    int updateData(UserRoles userRoles);

    /**
     * id查询数据
     *
     * @param id id
     * @return UserRoles
     */
    UserRoles findById(Long id);

    UserRoles queryUserRolesById(Integer userRolesId);
}
