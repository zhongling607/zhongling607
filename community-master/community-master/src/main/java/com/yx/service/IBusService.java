package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Bus;

public interface IBusService  extends IService<Bus> {
    PageInfo<Bus> findBusAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Bus>
     */
    IPage<Bus> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param bus
     * @return int
     */
    int add(Bus bus);

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
     * @param bus
     * @return int
     */
    int updateData(Bus bus);

    /**
     * id查询数据
     *
     * @param id id
     * @return Bus
     */
    Bus findById(Long id);

    Bus queryBusById(Integer busId);
}
