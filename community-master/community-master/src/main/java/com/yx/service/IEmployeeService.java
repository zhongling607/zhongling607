package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Employee;

public interface IEmployeeService extends IService<Employee> {
    PageInfo<Employee> findEmployeeAll(int page, int pageSize, String employee);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Employee>
     */
    IPage<Employee> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param employee
     * @return int
     */
    int add(Employee employee);

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
     * @param employee
     * @return int
     */
    int updateData(Employee employee);

    /**
     * id查询数据
     *
     * @param id id
     * @return Employee
     */
    Employee findById(Long id);

    Employee queryEmployeeById(Integer employeeId);
}
