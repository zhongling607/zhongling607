package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Contract;


/* 服务类*/


public interface IContractService extends IService<Contract> {


    PageInfo<Contract> findContractAll(int page, int pageSize, String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Contract>
     */
    IPage<Contract> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param contract
     * @return int
     */
    int add(Contract contract);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param contract
     * @return int
     */
    int updateData(Contract contract);

    /**
     * id查询数据
     *
     * @param id id
     * @return Contract
     */
    Contract findById(Long id);

    Contract queryContractById(Integer contractId);
}
