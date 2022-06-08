package com.yx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="菜单对象", description="菜单信息")
public class Menus {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String title;//菜单名称
    private String icon;
    private Integer fatherId;//上一级菜单id
    private String href;//路径
    private String target;//
    private List<Menus> child;//子菜单
}
