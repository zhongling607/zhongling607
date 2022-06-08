package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.PaymentMapper;
import com.yx.model.Payment;
import com.yx.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PaymentServiceImpl  extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {
    @Autowired
    private PaymentMapper
            paymentDao;
    @Override
    public PageInfo<Payment> findPaymentAll(int page, int pageSize, String numbers) {
        PageHelper.startPage(page,pageSize);
        List<Payment>
                list=paymentDao.queryPaymentAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Payment> findListByPage(Integer page, Integer pageCount){
        IPage<Payment>
                wherePage = new Page<>(page, pageCount);
        Payment
                where = new Payment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Payment payment){
        return baseMapper.insert(payment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Payment payment){
        return baseMapper.updateById(payment);
    }

    @Override
    public Payment findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Payment queryPaymentById(Integer paymentId) {
        return paymentDao.queryPaymentById(paymentId);
    }
}
