package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Daily;

public interface IDailyService extends IService<Daily> {
    PageInfo<Daily> findDailyAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Daily>
     */
    IPage<Daily> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param daily
     * @return int
     */
    int add(Daily daily);

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
     * @param daily
     * @return int
     */
    int updateData(Daily daily);

    /**
     * id查询数据
     *
     * @param id id
     * @return Daily
     */
    Daily findById(Long id);

    Daily queryDailyById(Integer dailyId);


}
