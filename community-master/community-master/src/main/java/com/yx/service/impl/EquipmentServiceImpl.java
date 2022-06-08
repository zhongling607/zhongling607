package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.EquipmentMapper;
import com.yx.model.Equipment;
import com.yx.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements IEquipmentService {
    @Autowired
    private EquipmentMapper
            equipmentDao;
    @Override
    public PageInfo<Equipment> findEquipmentAll(int page, int pageSize, String names) {
        PageHelper.startPage(page,pageSize);
        List<Equipment>
                list=equipmentDao.queryEquipmentAll(names);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Equipment> findListByPage(Integer page, Integer pageCount){
        IPage<Equipment> wherePage = new Page<>(page, pageCount);
        Equipment
                where = new Equipment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Equipment equipment){
        return baseMapper.insert(equipment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Equipment equipment){
        return baseMapper.updateById(equipment);
    }

    @Override
    public Equipment findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Equipment queryEquipmentById(Integer equipmentId) {
        return equipmentDao.queryEquipmentById(equipmentId);
    }
}
