package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Employee;
import com.yx.service.IEmployeeService;
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

@Api(tags = {"人员信息"})
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IEmployeeService
            employeeService;


    @RequestMapping("/queryEmployeeAll")
    public JsonObject queryEmployeeAll(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "15") Integer limit,
                                       String employee){
        JsonObject
                object=new JsonObject();
        PageInfo<Employee>
                pageInfo= employeeService.findEmployeeAll(page,limit,employee);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryEmployee")
    public List<Employee> queryEmployee(){
        PageInfo<Employee> pageInfo= employeeService.findEmployeeAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Employee employee){
        int num= employeeService.add(employee);
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
            employeeService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Employee employee){
        int num= employeeService.updateData(employee);
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
    public IPage<Employee> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return employeeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }


}
