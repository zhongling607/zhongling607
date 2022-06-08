package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.PersonMapper;
import com.yx.model.Person;
import com.yx.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {
    @Autowired
    private PersonMapper personDao;
    @Override
    public PageInfo<Person> findPersonAll(int page, int pageSize, String numbers,int userId) {
        PageHelper.startPage(page,pageSize);
        List<Person>
                list=personDao.queryPersonAll(numbers,userId);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Person> findListByPage(Integer page, Integer pageCount){
        IPage<Person> wherePage = new Page<>(page, pageCount);
        Person
                where = new Person();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Person person){
        return baseMapper.insert(person);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Person person){
        return baseMapper.updateById(person);
    }

    @Override
    public Person findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Person queryPersonById(Integer personId) {
        return personDao.queryPersonById(personId);
    }
}
