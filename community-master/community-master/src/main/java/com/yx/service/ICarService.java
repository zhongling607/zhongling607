package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Car;

public interface ICarService extends IService<Car> {
    PageInfo<Car> findCarAll(int page, int pageSize, String number);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Car>
     */
    IPage<Car> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param car
     * @return int
     */
    int add(Car car);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param car
     * @return int
     */
    int updateData(Car car);

    /**
     * id查询数据
     *
     * @param id id
     * @return Car
     */
    Car findById(Long id);

    Car queryCarById(Integer carId);
}
