package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Instruments;

public interface IInstrumentsService  extends IService<Instruments> {
    PageInfo<Instruments> findInstrumentsAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Instruments>
     */
    IPage<Instruments> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param instruments
     * @return int
     */
    int add(Instruments instruments);

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
     * @param instruments
     * @return int
     */
    int updateData(Instruments instruments);

    /**
     * id查询数据
     *
     * @param id id
     * @return Instruments
     */
    Instruments findById(Long id);

    Instruments queryInstrumentsById(Integer instrumentsId);
}
