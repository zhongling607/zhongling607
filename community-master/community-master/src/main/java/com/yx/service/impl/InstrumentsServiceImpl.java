package com.yx.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.InstrumentsMapper;
import com.yx.model.Instruments;
import com.yx.service.IInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class InstrumentsServiceImpl  extends ServiceImpl<InstrumentsMapper, Instruments> implements IInstrumentsService {
    @Autowired
    private InstrumentsMapper
            instrumentsDao;
    @Override
    public PageInfo<Instruments> findInstrumentsAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Instruments>
                list=instrumentsDao.queryInstrumentsAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Instruments> findListByPage(Integer page, Integer pageCount){
        IPage<Instruments> wherePage = new Page<>(page, pageCount);
        Instruments
                where = new Instruments();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Instruments instruments){
        return baseMapper.insert(instruments);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Instruments instruments){
        return baseMapper.updateById(instruments);
    }

    @Override
    public Instruments findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Instruments queryInstrumentsById(Integer instrumentsId) {
        return instrumentsDao.queryInstrumentsById(instrumentsId);
    }
}


