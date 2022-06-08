package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Equipment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("equipmentDao")
public interface EquipmentMapper extends BaseMapper<Equipment> {
    List<Equipment> queryEquipmentAll(@Param("names") String names);
    /**
     * 通过equipment中equipment_id查找equipment
     */
    Equipment queryEquipmentById(@Param("equipmentId") Integer equipmentId);
}
