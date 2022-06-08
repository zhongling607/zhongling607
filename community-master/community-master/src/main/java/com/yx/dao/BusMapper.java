package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Bus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("busDao")
public interface BusMapper   extends BaseMapper<Bus> {
    List<Bus> queryBusAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过bus中bus_id查找bus
     */
    Bus queryBusById(@Param("busId") Integer busId);
}
