package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("paymentDao")
public interface PaymentMapper  extends BaseMapper<Payment> {
    List<Payment> queryPaymentAll(@Param("numbers") String numbers);
    /**
     * 通过payment中payment_id查找payment
     */
    Payment queryPaymentById(@Param("paymentId") Integer paymentId);
}
