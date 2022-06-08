package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.EmployeeMapper;
import com.yx.model.Employee;
import com.yx.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper
            employeeDao;
    @Override
    public PageInfo<Employee> findEmployeeAll(int page, int pageSize, String employee) {
        PageHelper.startPage(page,pageSize);
        List<Employee>
                list=employeeDao.queryEmployeeAll(employee);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Employee> findListByPage(Integer page, Integer pageCount){
        IPage<Employee> wherePage = new Page<>(page, pageCount);
        Employee
                where = new Employee();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Employee employee){
        return baseMapper.insert(employee);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Employee employee){
        return baseMapper.updateById(employee);
    }

    @Override
    public Employee findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Employee queryEmployeeById(Integer employeeId) {
        return employeeDao.queryEmployeeById(employeeId);
    }

}
