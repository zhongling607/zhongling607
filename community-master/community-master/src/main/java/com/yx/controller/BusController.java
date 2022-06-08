package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Bus;
import com.yx.model.Userinfo;
import com.yx.service.IBusService;
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
@RequestMapping("/bus")
public class BusController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBusService
            busService;


    @RequestMapping("/queryBusAll")
    public JsonObject queryBusAll(@RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "15") Integer limit,
                                  String numbers, HttpServletRequest request){
        HttpSession session = request.getSession();
        Userinfo user =(Userinfo)session.getAttribute("user");
        JsonObject object=new JsonObject();
        PageInfo<Bus>
                pageInfo= busService.findBusAll(page,limit,numbers,user.getId());
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

   /*
    @RequestMapping("/queryBus")
    public List<Bus> queryBus(){
        PageInfo<Bus> pageInfo= busService.findBusAll(1,100,null);
        return pageInfo.getList();
    }*/


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Bus bus){
        int num= busService.add(bus);
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
            busService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Bus bus){
        int num= busService.updateData(bus);
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
    public IPage<Bus> findListByPage(@RequestParam Integer page,
                                     @RequestParam Integer pageCount){
        return busService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Bus findById(@PathVariable Long id){
        return busService.findById(id);
    }

}
