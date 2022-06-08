package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Attendance;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("attendanceDao")
public interface AttendanceMapper  extends BaseMapper<Attendance> {
    List<Attendance> queryAttendanceAll(@Param("numbers") String numbers,@Param("userId") int userId);
    /**
     * 通过attendance中attendance_id查找attendance
     */
    Attendance queryAttendanceById(@Param("attendanceId") Integer attendanceId);
}
