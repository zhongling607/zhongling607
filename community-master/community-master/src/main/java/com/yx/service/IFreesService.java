package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Frees;

public interface IFreesService  extends IService<Frees> {
    PageInfo<Frees> findFreesAll(int page, int pageSize, String type);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Frees>
     */
    IPage<Frees> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param frees
     * @return int
     */
    int add(Frees frees);

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
     * @param frees
     * @return int
     */
    int updateData(Frees frees);

    /**
     * id查询数据
     *
     * @param id id
     * @return Frees
     */
    Frees findById(Long id);

    Frees queryFreesById(Integer freesId);
}
