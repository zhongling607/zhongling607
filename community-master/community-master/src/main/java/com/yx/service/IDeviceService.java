package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Device;

public interface IDeviceService  extends IService<Device> {
    PageInfo<Device> findDeviceAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Device>
     */
    IPage<Device> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param device
     * @return int
     */
    int add(Device device);

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
     * @param device
     * @return int
     */
    int updateData(Device device);

    /**
     * id查询数据
     *
     * @param id id
     * @return Device
     */
    Device findById(Long id);

    Device queryDeviceById(Integer deviceId);
}
