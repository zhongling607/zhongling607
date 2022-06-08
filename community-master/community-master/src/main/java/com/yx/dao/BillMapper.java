package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("billDao")
public interface BillMapper  extends BaseMapper<Bill> {
    List<Bill> queryBillAll(@Param("numbers") String numbers);
    /**
     * 通过bill中bill_id查找bill
     */
    Bill queryBillById(@Param("billId") Integer billId);
}
