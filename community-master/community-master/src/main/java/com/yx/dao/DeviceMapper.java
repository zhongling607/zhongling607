package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("deviceDao")
public interface DeviceMapper   extends BaseMapper<Device> {
    List<Device> queryDeviceAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过device中device_id查找device
     */
    Device queryDeviceById(@Param("deviceId") Integer deviceId);
}
