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
@ApiModel(value="项目设备汇总对象", description="项目设备信息")
public class Equip {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private Integer car;//车载
    private Integer hand;//便携式
    private Integer tunnel;//隧道检测
    private Integer antenna;//天线检测
    private String computerSum;//电脑数量
    private String drillingSum;//钻机数量
    private String endoscopeSum;//内窥镜数量
}
