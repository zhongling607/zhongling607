package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ResumesMapper;
import com.yx.model.Resumes;
import com.yx.service.IResumesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ResumesServiceImpl  extends ServiceImpl<ResumesMapper, Resumes> implements IResumesService {
    @Autowired
    private ResumesMapper
            resumesDao;
    @Override
    public PageInfo<Resumes> findResumesAll(int page, int pageSize, String status, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Resumes>
                list=resumesDao.queryResumesAll(status,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Resumes> findListByPage(Integer page, Integer pageCount){
        IPage<Resumes>
                wherePage = new Page<>(page, pageCount);
        Resumes
                where = new Resumes();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Resumes resumes){
        return baseMapper.insert(resumes);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Resumes resumes){
        return baseMapper.updateById(resumes);
    }

    @Override
    public Resumes findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Resumes queryResumesById(Integer resumesId) {
        return resumesDao.queryResumesById(resumesId);
    }
}
