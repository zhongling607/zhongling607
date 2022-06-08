package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("managerDao")
public interface ManagerMapper extends BaseMapper<Manager> {
    List<Manager> queryManagerAll(@Param("numbers") String numbers);
    /**
     * 通过manager中manager_id查找manager
     */
    Manager queryManagerById(@Param("managerId") Integer managerId);
}
