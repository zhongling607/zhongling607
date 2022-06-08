package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Equip;

public interface IEquipService  extends IService<Equip> {
    PageInfo<Equip> findEquipAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Equip>
     */
    IPage<Equip> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param equip
     * @return int
     */
    int add(Equip equip);

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
     * @param equip
     * @return int
     */
    int updateData(Equip equip);

    /**
     * id查询数据
     *
     * @param id id
     * @return Equip
     */
    Equip findById(Long id);
    Equip queryEquipById(Integer equipId);
}
