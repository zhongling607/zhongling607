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
@ApiModel(value="项目进度对象", description="项目进度信息")
public class Daily {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    @TableField(exist = false)
    private String numbers;//合同编号
    @TableField(exist = false)
    private String name;//合同名称
    private String date;//日期
    private String carLength;//车载里程
    private String handLength;//便携式里程
    private String collectNum;//采集进度
    private String checkNum;//排查进度
    private String checkSum;//排查进度
    private String drillNum;//钻孔
    private String emptyNum;//空洞
    private String voidNum;//脱空
    private String looseNum;//疏松
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String remarks;//备注

}
