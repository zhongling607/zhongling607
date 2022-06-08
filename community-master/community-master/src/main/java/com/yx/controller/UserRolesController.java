package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.UserRoles;
import com.yx.service.IUserRolesService;
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
@RequestMapping("/userRoles")
public class UserRolesController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserRolesService
            userRolesService;


    @RequestMapping("/queryUserRolesAll")
    public JsonObject queryUserRolesAll(@RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit,
                                        String username){
        JsonObject
                object=new JsonObject();
        PageInfo<UserRoles>
                pageInfo= userRolesService.findUserRolesAll(page,limit,username);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryUserRoles")
    public List<UserRoles> queryUserRoles(){
        PageInfo<UserRoles> pageInfo= userRolesService.findUserRolesAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody UserRoles userRoles){
        int num= userRolesService.add(userRoles);
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
            userRolesService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody UserRoles userRoles){
        int num= userRolesService.updateData(userRoles);
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
    public IPage<UserRoles> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount){
        return userRolesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public UserRoles findById(@PathVariable Long id){
        return userRolesService.findById(id);
    }

}
