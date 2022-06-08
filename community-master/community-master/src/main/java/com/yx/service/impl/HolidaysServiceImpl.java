package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.HolidaysMapper;
import com.yx.model.Holidays;
import com.yx.service.IHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HolidaysServiceImpl   extends ServiceImpl<HolidaysMapper, Holidays> implements IHolidaysService {
    @Autowired
    private HolidaysMapper
            holidaysDao;
    @Override
    public PageInfo<Holidays> findHolidaysAll(int page, int pageSize, String employee) {
        PageHelper.startPage(page,pageSize);
        List<Holidays>
                list=holidaysDao.queryHolidaysAll(employee);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Holidays> findListByPage(Integer page, Integer pageCount){
        IPage<Holidays>
                wherePage = new Page<>(page, pageCount);
        Holidays
                where = new Holidays();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Holidays holidays){
        return baseMapper.insert(holidays);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Holidays holidays){
        return baseMapper.updateById(holidays);
    }

    @Override
    public Holidays findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Holidays queryHolidaysById(Integer holidaysId) {
        return holidaysDao.queryHolidaysById(holidaysId);
    }
}
