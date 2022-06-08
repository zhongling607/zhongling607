package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.RolesMenus;
import com.yx.service.IRolesMenusService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Api(tags = {""})
@RestController
@RequestMapping("/rolesMenus")
public class RolesMenusController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRolesMenusService
            rolesMenusService;


    @RequestMapping("/queryRolesMenusAll")
    public JsonObject queryRolesMenusAll(@RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "15") Integer limit,
                                         String rolesId){
        JsonObject
                object=new JsonObject();
        PageInfo<RolesMenus>
                pageInfo= rolesMenusService.findRolesMenusAll(page,limit,rolesId);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryRolesMenus")
    public List<RolesMenus> queryRolesMenus(){
        PageInfo<RolesMenus> pageInfo= rolesMenusService.findRolesMenusAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody RolesMenus rolesMenus){
        int num= rolesMenusService.add(rolesMenus);
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
            rolesMenusService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody RolesMenus rolesMenus){
        int num= rolesMenusService.updateData(rolesMenus);
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
    public IPage<RolesMenus> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount){
        return rolesMenusService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public RolesMenus findById(@PathVariable Long id){
        return rolesMenusService.findById(id);
    }

}
