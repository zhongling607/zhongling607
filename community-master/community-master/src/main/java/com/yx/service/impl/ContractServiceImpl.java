package com.yx.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.ContractMapper;
import com.yx.model.Contract;
import com.yx.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kappy
 * @since 2020-11-08
 */
@Transactional
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    private ContractMapper contractDao;
    @Override
    public PageInfo<Contract> findContractAll(int page, int pageSize, String numbers) {
        PageHelper.startPage(page,pageSize);
        List<Contract> list=contractDao.queryContractAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public IPage<Contract> findListByPage(Integer page, Integer pageCount){
        IPage<Contract> wherePage = new Page<>(page, pageCount);
        Contract
                where = new Contract();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Contract contract){
        return baseMapper.insert(contract);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Contract contract){
        return baseMapper.updateById(contract);
    }

    @Override
    public Contract findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public Contract queryContractById(Integer contractId) {
        return contractDao.queryContractById(contractId);
    }
}
