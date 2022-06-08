package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.AttendanceMapper;
import com.yx.model.Attendance;
import com.yx.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AttendanceServiceImpl   extends ServiceImpl<AttendanceMapper, Attendance> implements IAttendanceService {
    @Autowired
    private AttendanceMapper
            attendanceDao;
    @Override
    public PageInfo<Attendance> findAttendanceAll(int page, int pageSize, String numbers, int userId) {
        PageHelper.startPage(page,pageSize);
        List<Attendance>
                list=attendanceDao.queryAttendanceAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Attendance> findListByPage(Integer page, Integer pageCount){
        IPage<Attendance>
                wherePage = new Page<>(page, pageCount);
        Attendance
                where = new Attendance();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Attendance attendance){
        return baseMapper.insert(attendance);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Attendance attendance){
        return baseMapper.updateById(attendance);
    }

    @Override
    public Attendance findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Attendance queryAttendanceById(Integer attendanceId) {
        return attendanceDao.queryAttendanceById(attendanceId);
    }
}
