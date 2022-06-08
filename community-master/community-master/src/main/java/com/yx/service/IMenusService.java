package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Menus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IMenusService extends IService<Menus> {
    PageInfo<Menus> findMenusAll(int page, int pageSize, String menusName);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Menus>
     */
    IPage<Menus> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param menus
     * @return int
     */
    int add(Menus menus);

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
     * @param menus
     * @return int
     */
    int updateData(Menus menus);

    /**
     * id查询数据
     *
     * @param id id
     * @return Menus
     */
    Menus findById(Long id);

    List<Menus> queryMenuByUserId(Integer userId);
}
