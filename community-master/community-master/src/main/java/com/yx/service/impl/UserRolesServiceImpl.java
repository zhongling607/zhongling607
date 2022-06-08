package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserRolesMapper;
import com.yx.model.UserRoles;
import com.yx.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserRolesServiceImpl  extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {
    @Autowired
    private UserRolesMapper
            userRolesDao;
    @Override
    public PageInfo<UserRoles> findUserRolesAll(int page, int pageSize, String username) {
        PageHelper.startPage(page,pageSize);
        List<UserRoles>
                list=userRolesDao.queryUserRolesAll(username);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<UserRoles> findListByPage(Integer page, Integer pageCount){
        IPage<UserRoles> wherePage = new Page<>(page, pageCount);
        UserRoles
                where = new UserRoles();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(UserRoles userRoles){
        return baseMapper.insert(userRoles);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(UserRoles userRoles){
        return baseMapper.updateById(userRoles);
    }

    @Override
    public UserRoles findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public UserRoles queryUserRolesById(Integer userRolesId) {
        return userRolesDao.queryUserRolesById(userRolesId);
    }
}
