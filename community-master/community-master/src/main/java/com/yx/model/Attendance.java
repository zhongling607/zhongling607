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
@ApiModel(value="项目用工统计对象", description="项目用工统计信息")
public class Attendance {
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
    private String year;//年份
    private String month;//月份
    private String employee;//年份
    private String attend;//月份
}
