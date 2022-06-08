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
@ApiModel(value="开票对象", description="开票信息")
public class Products {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//项目编号
    private String name;//项目名称
    private String year;//年
    private String month;//月
    private String collectSum;//采集进度
    private String checkNum;//排查进度
    private String leader;//项目负责人
    private String sale;//销售
    private String customer;//甲方
    private String type;//合同类型
    private String ves;//产值
    private String sums;//月进度
    private String money;//合同金额
    private String monthLine;//月测线汇总
    private String total;//项目总进度
}
