package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Car;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("carDao")
public interface CarMapper extends BaseMapper<Car> {
    List<Car> queryCarAll(@Param("number") String number);
    /**
     * 通过car中car_id查找car
     */
    Car queryCarById(@Param("carId") Integer carId);
}
