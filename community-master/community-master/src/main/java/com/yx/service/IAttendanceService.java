package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Attendance;

public interface IAttendanceService   extends IService<Attendance> {
    PageInfo<Attendance> findAttendanceAll(int page, int pageSize, String numbers,int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Attendance>
     */
    IPage<Attendance> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param attendance
     * @return int
     */
    int add(Attendance attendance);

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
     * @param attendance
     * @return int
     */
    int updateData(Attendance attendance);

    /**
     * id查询数据
     *
     * @param id id
     * @return Attendance
     */
    Attendance findById(Long id);

    Attendance queryAttendanceById(Integer attendanceId);
}
