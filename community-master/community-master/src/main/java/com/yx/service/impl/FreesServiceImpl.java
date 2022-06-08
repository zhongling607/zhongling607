package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.FreesMapper;
import com.yx.model.Frees;
import com.yx.service.IFreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FreesServiceImpl   extends ServiceImpl<FreesMapper, Frees> implements IFreesService {
    @Autowired
    private FreesMapper
            freesDao;
    @Override
    public PageInfo<Frees> findFreesAll(int page, int pageSize, String type) {
        PageHelper.startPage(page,pageSize);
        List<Frees>
                list=freesDao.queryFreesAll(type);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Frees> findListByPage(Integer page, Integer pageCount){
        IPage<Frees>
                wherePage = new Page<>(page, pageCount);
        Frees
                where = new Frees();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Frees frees){
        return baseMapper.insert(frees);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Frees frees){
        return baseMapper.updateById(frees);
    }

    @Override
    public Frees findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Frees queryFreesById(Integer freesId) {
        return freesDao.queryFreesById(freesId);
    }
}
