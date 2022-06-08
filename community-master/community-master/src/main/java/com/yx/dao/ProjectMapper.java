package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("projectDao")
public interface ProjectMapper  extends BaseMapper<Project> {
    List<Project> queryProjectAll(@Param("numbers") String numbers, @Param("userId") int userId);

    /**
     * 通过project中contract_id查找合同
     */
    Project queryProjectById(@Param("ProjectId") Integer ProjectId);
}
