package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Bill;

public interface IBillService extends IService<Bill> {
    PageInfo<Bill> findBillAll(int page, int pageSize, String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Bill>
     */
    IPage<Bill> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param bill
     * @return int
     */
    int add(Bill bill);

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
     * @param bill
     * @return int
     */
    int updateData(Bill bill);

    /**
     * id查询数据
     *
     * @param id id
     * @return Bill
     */
    Bill findById(Long id);

    Bill queryBillById(Integer billId);
}
