package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.CarMapper;
import com.yx.model.Car;
import com.yx.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {
    @Autowired
    private CarMapper
            carDao;
    @Override
    public PageInfo<Car> findCarAll(int page, int pageSize, String number) {
        PageHelper.startPage(page,pageSize);
        List<Car>
                list=carDao.queryCarAll(number);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Car> findListByPage(Integer page, Integer pageCount){
        IPage<Car> wherePage = new Page<>(page, pageCount);
        Car
                where = new Car();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Car car){
        return baseMapper.insert(car);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Car car){
        return baseMapper.updateById(car);
    }

    @Override
    public Car findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Car queryCarById(Integer carId) {
        return carDao.queryCarById(carId);
    }
}
