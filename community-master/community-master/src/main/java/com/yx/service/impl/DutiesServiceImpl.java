package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.DutiesMapper;
import com.yx.model.Duties;
import com.yx.service.IDutiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DutiesServiceImpl   extends ServiceImpl<DutiesMapper, Duties> implements IDutiesService {
    @Autowired
    private DutiesMapper
            dutiesDao;
    @Override
    public PageInfo<Duties> findDutiesAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Duties>
                list=dutiesDao.queryDutiesAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Duties> findListByPage(Integer page, Integer pageCount){
        IPage<Duties> wherePage = new Page<>(page, pageCount);
        Duties where = new Duties();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Duties duties){
        return baseMapper.insert(duties);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Duties duties){
        return baseMapper.updateById(duties);
    }

    @Override
    public Duties findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Duties queryDutiesById(Integer dutiesId) {
        return dutiesDao.queryDutiesById(dutiesId);
    }
}
