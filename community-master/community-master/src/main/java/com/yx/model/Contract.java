package com.yx.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author kappy
 * @since 2020-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="合同对象", description="合同基本信息")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String numbers;
    private String type;
    private String name;
    private String sale;
    private String customer;
    private String signDate;
    private Double unitPrice;
    private Double money;
    private String quality;
    private String remarks;
    private String period;
    private String fullName;
}
