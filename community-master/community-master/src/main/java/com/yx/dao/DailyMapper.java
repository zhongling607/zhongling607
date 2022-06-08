package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Daily;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dailyDao")
public interface DailyMapper extends BaseMapper<Daily> {
    List<Daily> queryDailyAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过daily中daily_id查找daily
     */
    Daily queryDailyById(@Param("dailyId") Integer dailyId);
}
