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
@ApiModel(value="项目人员对象", description="项目人员信息")
public class Person {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String numbers;//项目编号
    private String name;//项目名称
    private String contractId;//合同id
    private String employeeId;//人员id
    private String employee;//人员姓名
    private String position;//人员岗位
    private String date;//日期
    private String states;//状态
    private Double counts;//工作时长
    private String remarks;//备注
}
