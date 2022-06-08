package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Contract;
import com.yx.service.IContractService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kappy
 * @since 2020-11-08
 */
@Api(tags = {""})
@RestController
@RequestMapping("/contract")
public class ContractController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IContractService
            contractService;


    @RequestMapping("/queryContractAll")
    public JsonObject queryContractAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    String numbers)

    {
        JsonObject object=new JsonObject();
        PageInfo<Contract> pageInfo= contractService.findContractAll(page,limit,numbers);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryContract")
    public List<Contract> queryContract(){
        PageInfo<Contract> pageInfo= contractService.findContractAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Contract contract){
        int num= contractService.add(contract);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }

    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            contractService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Contract contract){
        int num= contractService.updateData(contract);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Contract> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return contractService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Contract findById(@PathVariable Long id){
        return contractService.findById(id);
    }

}
