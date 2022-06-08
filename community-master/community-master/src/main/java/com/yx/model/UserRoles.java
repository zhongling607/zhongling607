package com.yx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="用户角色对象", description="用户角色信息")
public class UserRoles {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String userId;//用户id
    private String username;//用户名
    private String rolesId;//角色id
    private String rolesName;//角色名
    private String createTime;//创建时间
    private String updateTime;//更新时间
}
