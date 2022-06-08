package com.yx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="项目对象", description="项目基本信息")

public class Project {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键

    private String numbers;

    private String name;
    private String startDate;//开始时间
    private Double roadLength;//道路里程
    private Double lineLength;//测线里程
    private String endDate;//结束时间
    private String period;//复测周期
    private String remarks;//备注
    private String contractId;//关联合同id
    private String leader;//项目负责人
    private String status;//项目状态
}
