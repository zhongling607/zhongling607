package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Duties;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dutiesDao")
public interface DutiesMapper   extends BaseMapper<Duties> {
    List<Duties> queryDutiesAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过duties中duties_id查找Duties
     */
    Duties queryDutiesById(@Param("dutiesId") Integer dutiesId);
}
