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
@ApiModel(value="项目设备对象", description="项目设备对象")
public class Device {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String date;//日期
    private String equipmentId;//设备id
    private String code;//设备号
    private String names;//设备名称
    private String type;//设备型号
    private String remarks;//备注
    private String counts;//数量
}
