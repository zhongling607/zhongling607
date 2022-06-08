package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.DeviceMapper;
import com.yx.model.Device;
import com.yx.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DeviceServiceImpl  extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {
    @Autowired
    private DeviceMapper
            deviceDao;
    @Override
    public PageInfo<Device> findDeviceAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Device>
                list=deviceDao.queryDeviceAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Device> findListByPage(Integer page, Integer pageCount){
        IPage<Device>
                wherePage = new Page<>(page, pageCount);
        Device
                where = new Device();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Device device){
        return baseMapper.insert(device);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Device device){
        return baseMapper.updateById(device);
    }

    @Override
    public Device findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Device queryDeviceById(Integer deviceId) {
        return deviceDao.queryDeviceById(deviceId);
    }
}
