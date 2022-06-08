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
@ApiModel(value="人员休假对象", description="人员休假信息")
public class Holidays {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String employeeId;//员工id
    private String employee;//员工姓名
    private String position;//员工岗位
    private String date;//填写时间
    private String startDate;//开始时间
    private String endDate;//结束时间
    private String dates;//请假天数
    private String remarks;//备注
}
