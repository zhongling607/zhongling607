package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.MenusMapper;
import com.yx.model.Menus;
import com.yx.service.IMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements IMenusService {
    @Autowired
    private MenusMapper
            menusDao;
    @Override
    public PageInfo<Menus> findMenusAll(int page, int pageSize, String menusName) {
        PageHelper.startPage(page,pageSize);
        List<Menus>
                list=menusDao.queryMenusAll(menusName);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Menus> findListByPage(Integer page, Integer pageCount){
        IPage<Menus> wherePage = new Page<>(page, pageCount);
        Menus
                where = new Menus();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Menus menus){
        return baseMapper.insert(menus);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Menus menus){
        return baseMapper.updateById(menus);
    }

    @Override
    public Menus findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<Menus> queryMenuByUserId(Integer userId) {
        return menusDao.queryMenuByUserId(userId);
    }
}

