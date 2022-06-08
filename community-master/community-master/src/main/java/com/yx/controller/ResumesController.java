package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Resumes;
import com.yx.model.Userinfo;
import com.yx.service.IResumesService;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Api(tags = {""})
@RestController
@RequestMapping("/resumes")
public class ResumesController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IResumesService
            resumesService;


    @RequestMapping("/queryResumesAll")
    public JsonObject queryResumesAll(@RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "15") Integer limit,
                                      String status, HttpServletRequest request){
        HttpSession
                session = request.getSession();
        Userinfo
                user =(Userinfo)session.getAttribute("user");
        JsonObject object=new JsonObject();
        PageInfo<Resumes>
                pageInfo= resumesService.findResumesAll(page,limit,status,user.getId());
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }
    /*
        @RequestMapping("/queryResumes")
        public List<Resumes> queryResumes(){
            PageInfo<Resumes> pageInfo= resumesService.findResumesAll(1,100,null);
            return pageInfo.getList();
        }
    */
    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Resumes resumes){
        int num= resumesService.add(resumes);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }

    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String>
                list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            resumesService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Resumes resumes){
        int num= resumesService.updateData(resumes);
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
    public IPage<Resumes> findListByPage(@RequestParam Integer page,
                                         @RequestParam Integer pageCount){
        return resumesService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Resumes findById(@PathVariable Long id){
        return resumesService.findById(id);
    }
}
