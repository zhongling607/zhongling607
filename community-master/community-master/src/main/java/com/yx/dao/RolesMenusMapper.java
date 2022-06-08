package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.RolesMenus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("rolesMenusDao")
public interface RolesMenusMapper extends BaseMapper<RolesMenus> {
    List<RolesMenus> queryRolesMenusAll(@Param("rolesId") String rolesId);
    /**
     * 通过rolesMenus中rolesMenus_id查找rolesMenus
     */
    RolesMenus queryRolesMenusById(@Param("rolesMenusId") Integer rolesMenusId);
}
