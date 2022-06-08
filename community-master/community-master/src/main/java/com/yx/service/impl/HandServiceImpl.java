package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.HandMapper;
import com.yx.model.Hand;
import com.yx.service.IHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HandServiceImpl extends ServiceImpl<HandMapper, Hand> implements IHandService {
    @Autowired
    private HandMapper
            handDao;
    @Override
    public PageInfo<Hand> findHandAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Hand>
                list=handDao.queryHandAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Hand> findListByPage(Integer page, Integer pageCount){
        IPage<Hand>
                wherePage = new Page<>(page, pageCount);
        Hand
                where = new Hand();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Hand hand){
        return baseMapper.insert(hand);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Hand hand){
        return baseMapper.updateById(hand);
    }

    @Override
    public Hand findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Hand queryHandById(Integer handId) {
        return handDao.queryHandById(handId);
    }
}
