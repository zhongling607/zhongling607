package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Contract;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *

 */
@Component("contractDao")
public interface ContractMapper extends BaseMapper<Contract> {

    List<Contract> queryContractAll(@Param("numbers") String numbers);

    /**
     * 通过house中building_id查找building
     */
    Contract queryContractById(@Param("contractId") Integer contractId);
}
