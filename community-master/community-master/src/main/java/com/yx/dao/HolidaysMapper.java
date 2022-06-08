package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Holidays;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("holidaysDao")
public interface HolidaysMapper   extends BaseMapper<Holidays> {
    List<Holidays> queryHolidaysAll(@Param("employee") String employee);
    /**
     * 通过holidays中holidays_id查找holidays
     */
    Holidays queryHolidaysById(@Param("holidaysId") Integer holidaysId);

}
