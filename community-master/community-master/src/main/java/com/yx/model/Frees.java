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
@ApiModel(value="闲置信息对象", description="闲置信息")
public class Frees {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//主键
    private String freeMan;//闲置人员
    private String personNum;//闲置人员人数
    private String equipmentCar;//车载式设备
    private String carNum;//车载式数量
    private String equipmentHand;//手推式设备
    private String handNum;//手推式数量
    private String carCode;//车牌号
    private String carFree;//数量
    private String type;//类型
}
