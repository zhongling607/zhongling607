package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Payment;

public interface IPaymentService  extends IService<Payment> {
    PageInfo<Payment> findPaymentAll(int page, int pageSize, String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Payment>
     */
    IPage<Payment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param payment
     * @return int
     */
    int add(Payment payment);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param payment
     * @return int
     */
    int updateData(Payment payment);

    /**
     * id查询数据
     *
     * @param id id
     * @return Payment
     */
    Payment findById(Long id);

    Payment queryPaymentById(Integer paymentId);
}
