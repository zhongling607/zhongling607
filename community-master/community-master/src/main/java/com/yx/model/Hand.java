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
@ApiModel(value="项目完工资料对象", description="项目完工资料信息")
public class Hand {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String isReport;//是否提交报告
    private String submitReport;//提交报告时间
    private String completeOrder;//完工单
    private String hand;//交接单
    private String workload;//工作量确认单提交
    private String checkFile;//验收单
    private String isFinish;//是否完成
    private String finishDate;//完成日期
    private String status;//工作状态
    private String remarks;//备注
}
