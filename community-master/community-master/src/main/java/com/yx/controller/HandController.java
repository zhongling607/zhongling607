package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Hand;
import com.yx.model.Userinfo;
import com.yx.service.IHandService;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Api(tags = {""})
@RestController
@RequestMapping("/hand")
public class HandController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IHandService
            handService;


    @RequestMapping("/queryHandAll")
    public JsonObject queryHandAll(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "15") Integer limit,
                                       String numbers, HttpServletRequest request){
        HttpSession session = request.getSession();
        Userinfo user =(Userinfo)session.getAttribute("user");
        JsonObject
                object=new JsonObject();
        PageInfo<Hand>
                pageInfo= handService.findHandAll(page,limit,numbers,user.getId());
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }
/*
    @RequestMapping("/queryHand")
    public List<Hand> queryHand(){
        PageInfo<Hand>
                pageInfo= handService.findHandAll(1,100,null);
        return pageInfo.getList();
    }
*/

    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Hand hand){
        int num= handService.add(hand);
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
            handService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Hand hand){
        int num= handService.updateData(hand);
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
    public IPage<Hand> findListByPage(@RequestParam Integer page,
                                      @RequestParam Integer pageCount){
        return handService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Hand findById(@PathVariable Long id){
        return handService.findById(id);
    }
}
