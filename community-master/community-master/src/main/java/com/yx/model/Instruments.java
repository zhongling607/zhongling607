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
@ApiModel(value="其他设备对象", description="其他设备信息")
public class Instruments {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String computerType;//电脑型号
    private Integer computerNum;//电脑数量
    private String drillingType;//钻机型号
    private Integer drillingNum;//钻机数量
    private String endoscopeType;//内窥镜型号
    private Integer endoscopeNum;//内窥镜数量
    private String remarks;//备注
}
