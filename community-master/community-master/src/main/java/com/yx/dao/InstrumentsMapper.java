package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Instruments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("instrumentsDao")
public interface InstrumentsMapper  extends BaseMapper<Instruments> {

    List<Instruments> queryInstrumentsAll(@Param("numbers") String numbers, @Param("userId") int userId);
    /**
     * 通过bill中bill_id查找bill
     */
    Instruments queryInstrumentsById(@Param("instrumentsId") Integer instrumentsId);
}
