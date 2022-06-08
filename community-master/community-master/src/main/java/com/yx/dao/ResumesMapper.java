package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Resumes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("resumesDao")
public interface ResumesMapper    extends BaseMapper<Resumes> {
    List<Resumes> queryResumesAll(@Param("status") String numbers, @Param("userId") int userId);
    /**
     * 通过device中device_id查找device
     */
    Resumes queryResumesById(@Param("resumesId") Integer resumesId);
}
