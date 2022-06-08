package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("rolesDao")
public interface RolesMapper extends BaseMapper<Roles> {
    List<Roles> queryRolesAll(@Param("rolesName") String rolesName);
    /**
     * 通过roles中roles_id查找roles
     */
    Roles queryRolesById(@Param("rolesId") Integer rolesId);
}
