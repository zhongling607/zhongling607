package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Frees;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("freesDao")
public interface FreesMapper   extends BaseMapper<Frees> {
    List<Frees> queryFreesAll(@Param("type") String type);
    /**
     * 通过frees中frees_id查找frees
     */
    Frees queryFreesById(@Param("freesId") Integer freesId);
}
