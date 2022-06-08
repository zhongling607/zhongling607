package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.BusMapper;
import com.yx.model.Bus;
import com.yx.service.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BusServiceImpl  extends ServiceImpl<BusMapper, Bus> implements IBusService {
    @Autowired
    private BusMapper
            busDao;
    @Override
    public PageInfo<Bus> findBusAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Bus> list=busDao.queryBusAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Bus> findListByPage(Integer page, Integer pageCount){
        IPage<Bus> wherePage = new Page<>(page, pageCount);
        Bus
                where = new Bus();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Bus bus){
        return baseMapper.insert(bus);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Bus bus){
        return baseMapper.updateById(bus);
    }

    @Override
    public Bus findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Bus queryBusById(Integer busId) {
        return busDao.queryBusById(busId);
    }
}
