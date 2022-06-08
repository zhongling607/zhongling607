package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Equipment;
import com.yx.service.IEquipmentService;
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

@Api(tags = {""})
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IEquipmentService
            equipmentService;


    @RequestMapping("/queryEquipmentAll")
    public JsonObject queryEquipmentAll(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit,
                                        String names){
        JsonObject
                object=new JsonObject();
        PageInfo<Equipment>
                pageInfo= equipmentService.findEquipmentAll(page,limit,names);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryEquipment")
    public List<Equipment> queryEquipment(){
        PageInfo<Equipment> pageInfo= equipmentService.findEquipmentAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Equipment equipment){
        int num= equipmentService.add(equipment);
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
            equipmentService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Equipment equipment){
        int num= equipmentService.updateData(equipment);
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
    public IPage<Equipment> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount){
        return equipmentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Equipment findById(@PathVariable Long id){
        return equipmentService.findById(id);
    }

}
