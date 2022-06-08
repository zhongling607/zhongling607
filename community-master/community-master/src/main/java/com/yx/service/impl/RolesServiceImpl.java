package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.RolesMapper;
import com.yx.model.Roles;
import com.yx.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {
    @Autowired
    private RolesMapper
            rolesDao;
    @Override
    public PageInfo<Roles> findRolesAll(int page, int pageSize, String rolesName) {
        PageHelper.startPage(page,pageSize);
        List<Roles>
                list=rolesDao.queryRolesAll(rolesName);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Roles> findListByPage(Integer page, Integer pageCount){
        IPage<Roles> wherePage = new Page<>(page, pageCount);
        Roles
                where = new Roles();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Roles roles){
        return baseMapper.insert(roles);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Roles roles){
        return baseMapper.updateById(roles);
    }

    @Override
    public Roles findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Roles queryRolesById(Integer rolesId) {
        return rolesDao.queryRolesById(rolesId);
    }
}
