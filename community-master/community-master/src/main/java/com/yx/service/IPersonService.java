package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Person;

public interface IPersonService extends IService<Person> {
    PageInfo<Person> findPersonAll(int page, int pageSize, String numbers,int userId);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Person>
     */
    IPage<Person> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param person
     * @return int
     */
    int add(Person person);

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
     * @param person
     * @return int
     */
    int updateData(Person person);

    /**
     * id查询数据
     *
     * @param id id
     * @return Person
     */
    Person findById(Long id);

    Person queryPersonById(Integer personId);
}
