package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Equipment;

public interface IEquipmentService extends IService<Equipment> {
    PageInfo<Equipment> findEquipmentAll(int page, int pageSize, String names);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Equipment>
     */
    IPage<Equipment> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param equipment
     * @return int
     */
    int add(Equipment equipment);

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
     * @param equipment
     * @return int
     */
    int updateData(Equipment equipment);

    /**
     * id查询数据
     *
     * @param id id
     * @return Equipment
     */
    Equipment findById(Long id);

    Equipment queryEquipmentById(Integer equipmentId);
}
