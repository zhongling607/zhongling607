package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDao")
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> queryEmployeeAll(@Param("employee") String employee);
    /**
     * 通过employee中employee_id查找employee
     */
    Employee queryEmployeeById(@Param("employeeId") Integer employeeId);
}
