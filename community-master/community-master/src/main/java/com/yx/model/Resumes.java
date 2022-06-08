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
@ApiModel(value="项目汇总统计对象", description="项目汇总统计信息")
public class Resumes {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String leader;//负责人
    private String personSum;//项目人数
    private String employee;//项目人员
    private Integer car;//车载雷达
    private Integer hand;//便携式雷达
    private String carCode;//车牌号
    private String days;//施工天数
    private String startDate;//预计开始时间
    private String endDate;//预计完成时间
    private String collects;//采集进度
    private String checks;//排查进度
    private String emptySum;//空洞数
    private String voidSum;//脱空数
    private String looseSum;//疏松数
    private String status;//项目状态
}
