package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProjectService extends IService<Project> {
    PageInfo<Project> findProjectAll(int page, int pageSize, String numbers, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Contract>
     */
    IPage<Project> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param project
     * @return int
     */
    int add(Project project);

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
     * @param project
     * @return int
     */
    int updateData(Project project);

    /**
     * id查询数据
     *
     * @param id id
     * @return Contract
     */
    Project findById(Long id);

    Project queryProjectById(Integer projectId);

}
