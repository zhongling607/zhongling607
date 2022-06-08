package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ProjectMapper;
import com.yx.model.Project;
import com.yx.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service

public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {
    @Autowired
    private ProjectMapper projectDao;
    @Override
    public PageInfo<Project> findProjectAll(int page, int pageSize, String numbers, int userId) {
        List<Project> list=projectDao.queryProjectAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Project> findListByPage(Integer page, Integer pageCount) {
        IPage<Project> wherePage = new Page<>(page, pageCount);
        Project
                where = new Project();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Project project) {
        return baseMapper.insert(project);
    }

    @Override
    public int delete(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Project project) {
        return baseMapper.updateById(project);
    }

    @Override
    public Project findById(Long id) {
        return  baseMapper.selectById(id);
    }

    @Override
    public Project queryProjectById(Integer projectId) {
        return projectDao.queryProjectById(projectId);
    }

}
