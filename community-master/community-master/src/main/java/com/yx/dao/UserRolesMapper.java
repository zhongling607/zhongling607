package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.UserRoles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userRolesDao")
public interface UserRolesMapper extends BaseMapper<UserRoles> {
    List<UserRoles> queryUserRolesAll(@Param("username") String username);
    /**
     * 通过userRoles中userRoles_id查找userRoles
     */
    UserRoles queryUserRolesById(@Param("userRolesId") Integer userRolesId);
}
