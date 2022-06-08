package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Executing;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("executingDao")
public interface ExecutingMapper extends BaseMapper<Executing> {
    List<Executing> queryExecutingAll(@Param("numbers") String numbers,@Param("userId") int userId);
    /**
     * 通过executing中executing_id查找executing
     */
    Executing queryExecutingById(@Param("executingId") Integer executingId);
}
