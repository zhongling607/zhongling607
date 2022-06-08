package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.EquipMapper;
import com.yx.model.Equip;
import com.yx.service.IEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EquipServiceImpl  extends ServiceImpl<EquipMapper, Equip> implements IEquipService {
    @Autowired
    private EquipMapper
            equipDao;
    @Override
    public PageInfo<Equip> findEquipAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Equip>
                list=equipDao.queryEquipAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Equip> findListByPage(Integer page, Integer pageCount){
        IPage<Equip>
                wherePage = new Page<>(page, pageCount);
        Equip
                where = new Equip();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Equip equip){
        return baseMapper.insert(equip);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Equip equip){
        return baseMapper.updateById(equip);
    }

    @Override
    public Equip findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Equip queryEquipById(Integer equipId) {
        return equipDao.queryEquipById(equipId);
    }
}
