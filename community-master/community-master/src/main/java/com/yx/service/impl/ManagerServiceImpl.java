package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ManagerMapper;
import com.yx.model.Manager;
import com.yx.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
    @Autowired
    private ManagerMapper
            managerDao;
    @Override
    public PageInfo<Manager> findManagerAll(int page, int pageSize, String numbers) {
        PageHelper.startPage(page,pageSize);
        List<Manager>
                list=managerDao.queryManagerAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Manager> findListByPage(Integer page, Integer pageCount){
        IPage<Manager> wherePage = new Page<>(page, pageCount);
        Manager
                where = new Manager();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Manager manager){
        return baseMapper.insert(manager);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Manager manager){
        return baseMapper.updateById(manager);
    }

    @Override
    public Manager findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Manager queryManagerById(Integer managerId) {
        return managerDao.queryManagerById(managerId);
    }
}
