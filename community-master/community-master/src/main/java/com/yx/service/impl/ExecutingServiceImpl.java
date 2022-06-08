package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ExecutingMapper;
import com.yx.model.Executing;
import com.yx.service.IExecutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ExecutingServiceImpl  extends ServiceImpl<ExecutingMapper, Executing> implements IExecutingService {
    @Autowired
    private ExecutingMapper
            executingDao;
    @Override
    public PageInfo<Executing> findExecutingAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Executing>
                list=executingDao.queryExecutingAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Executing> findListByPage(Integer page, Integer pageCount){
        IPage<Executing>
                wherePage = new Page<>(page, pageCount);
        Executing
                where = new Executing();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Executing executing){
        return baseMapper.insert(executing);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Executing executing){
        return baseMapper.updateById(executing);
    }

    @Override
    public Executing findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Executing queryExecutingById(Integer executingId) {
        return executingDao.queryExecutingById(executingId);
    }
}
