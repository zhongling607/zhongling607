package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.DailyMapper;
import com.yx.model.Daily;
import com.yx.service.IDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements IDailyService {
    @Autowired
    private DailyMapper
            dailyDao;
    @Override
    public PageInfo<Daily> findDailyAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Daily>
                list=dailyDao.queryDailyAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Daily> findListByPage(Integer page, Integer pageCount){
        IPage<Daily> wherePage = new Page<>(page, pageCount);
        Daily
                where = new Daily();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Daily daily){
        return baseMapper.insert(daily);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Daily daily){
        return baseMapper.updateById(daily);
    }

    @Override
    public Daily findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Daily queryDailyById(Integer dailyId) {
        return dailyDao.queryDailyById(dailyId);
    }
}
