package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Hand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("handDao")
public interface HandMapper extends BaseMapper<Hand> {
    List<Hand> queryHandAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过hand中hand_id查找hand
     */
    Hand queryHandById(@Param("handId") Integer handId);
}
