package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Frees;
import com.yx.service.IFreesService;
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
@RequestMapping("/frees")
public class FreesController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IFreesService
            freesService;


    @RequestMapping("/queryFreesAll")
    public JsonObject queryFreesAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    String type){
        JsonObject
                object=new JsonObject();
        PageInfo<Frees>
                pageInfo= freesService.findFreesAll(page,limit,type);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryFrees")
    public List<Frees> queryFrees(){
        PageInfo<Frees> pageInfo= freesService.findFreesAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Frees frees){
        int num= freesService.add(frees);
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
            freesService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Frees frees){
        int num= freesService.updateData(frees);
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
    public IPage<Frees> findListByPage(@RequestParam Integer page,
                                       @RequestParam Integer pageCount){
        return freesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Frees findById(@PathVariable Long id){
        return freesService.findById(id);
    }
}
