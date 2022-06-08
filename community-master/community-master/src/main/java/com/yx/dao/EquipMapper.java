package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Equip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("equipDao")
public interface EquipMapper  extends BaseMapper<Equip> {
    List<Equip> queryEquipAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过hand中hand_id查找hand
     */
    Equip queryEquipById(@Param("equipId") Integer equipId);
}
