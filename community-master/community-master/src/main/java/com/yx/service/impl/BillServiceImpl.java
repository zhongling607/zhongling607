package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.BillMapper;
import com.yx.model.Bill;
import com.yx.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BillServiceImpl  extends ServiceImpl<BillMapper, Bill> implements IBillService {
    @Autowired
    private BillMapper
            billDao;
    @Override
    public PageInfo<Bill> findBillAll(int page, int pageSize, String numbers) {
        PageHelper.startPage(page,pageSize);
        List<Bill>
                list=billDao.queryBillAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Bill> findListByPage(Integer page, Integer pageCount){
        IPage<Bill> wherePage = new Page<>(page, pageCount);
        Bill
                where = new Bill();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Bill bill){
        return baseMapper.insert(bill);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Bill bill){
        return baseMapper.updateById(bill);
    }

    @Override
    public Bill findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Bill queryBillById(Integer billId) {
        return billDao.queryBillById(billId);
    }
}
