package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Resumes;

public interface IResumesService  extends IService<Resumes> {
    PageInfo<Resumes> findResumesAll(int page, int pageSize, String status, int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Daily>
     */
    IPage<Resumes> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param resumes
     * @return int
     */
    int add(Resumes resumes);

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
     * @param resumes
     * @return int
     */
    int updateData(Resumes resumes);

    /**
     * id查询数据
     *
     * @param id id
     * @return Resumes
     */
    Resumes findById(Long id);

    Resumes queryResumesById(Integer resumesId);

}
