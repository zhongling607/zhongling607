package com.yx.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("personDao")
public interface PersonMapper extends BaseMapper<Person> {
    List<Person> queryPersonAll(@Param("numbers") String numbers, @Param("userId") int userId);

    /**
     * 通过person中person_id查找person
     */
    Person queryPersonById(@Param("personId") Integer personId);
}
