package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Holidays;

public interface IHolidaysService  extends IService<Holidays> {
    PageInfo<Holidays> findHolidaysAll(int page, int pageSize, String employee);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Holidays>
     */
    IPage<Holidays> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param holidays
     * @return int
     */
    int add(Holidays holidays);

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
     * @param holidays
     * @return int
     */
    int updateData(Holidays holidays);

    /**
     * id查询数据
     *
     * @param id id
     * @return Holidays
     */
    Holidays findById(Long id);

    Holidays queryHolidaysById(Integer holidaysId);
}
