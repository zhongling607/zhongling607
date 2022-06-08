package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("menusDao")
public interface MenusMapper extends BaseMapper<Menus> {
    List<Menus> queryMenusAll(@Param("menuName") String menuName);
    /**
     * 通过userId查找menus
     */
    List<Menus> queryMenuByUserId(@Param("userId") Integer userId);
}
