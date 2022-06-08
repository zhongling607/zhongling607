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
@ApiModel(value="项目进度统计对象", description="项目进度统计信息")
public class Executing {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String sale;//销售
    private String customer;//甲方
    private String type;//检测类型
    private String money;//合同金额
    private String roadSum;//道路总里程
    private String lineSum;//测线总里程
    private String startDate;//检测开始时间
    private String endDate;//检测结束时间
    private String year;//年份
    private String month;//月份
    private String collectNum;//采集进度
    private String checkNum;//排查进度
    private String sums;//总进度
    private String drillNum;//钻孔数
    private String emptyNum;//空洞数
    private String voidNum;//脱空数
    private String looseNum;//疏松数
    private String leader;//项目负责人
    private String status;//项目状态

}
