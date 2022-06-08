package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.RolesMenusMapper;
import com.yx.model.RolesMenus;
import com.yx.service.IRolesMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RolesMenusServiceImpl extends ServiceImpl<RolesMenusMapper, RolesMenus> implements IRolesMenusService {
    @Autowired
    private RolesMenusMapper
            rolesMenusDao;
    @Override
    public PageInfo<RolesMenus> findRolesMenusAll(int page, int pageSize, String number) {
        PageHelper.startPage(page,pageSize);
        List<RolesMenus>
                list=rolesMenusDao.queryRolesMenusAll(number);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<RolesMenus> findListByPage(Integer page, Integer pageCount){
        IPage<RolesMenus> wherePage = new Page<>(page, pageCount);
        RolesMenus
                where = new RolesMenus();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(RolesMenus rolesMenus){
        return baseMapper.insert(rolesMenus);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(RolesMenus rolesMenus){
        return baseMapper.updateById(rolesMenus);
    }

    @Override
    public RolesMenus findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public RolesMenus queryRolesMenusById(Integer rolesMenusId) {
        return rolesMenusDao.queryRolesMenusById(rolesMenusId);
    }
}
