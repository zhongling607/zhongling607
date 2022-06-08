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
@ApiModel(value="出勤对象", description="出勤信息")
public class Duties {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String contractId;//合同id
    private String numbers;//合同编号
    private String name;//合同名称
    private String employee;//姓名
    private String year;//年
    private String month;//月
    private String days;//出勤天数
    private String leaves;//请假天数
    private String vacations;//出勤天数
}
