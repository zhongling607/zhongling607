package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Instruments;
import com.yx.model.Userinfo;
import com.yx.service.IInstrumentsService;
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
@RequestMapping("/instruments")
public class InstrumentsController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IInstrumentsService
            instrumentsService;


    @RequestMapping("/queryInstrumentsAll")
    public JsonObject queryInstrumentsAll(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "15") Integer limit,
                                          String numbers, HttpServletRequest request){
        HttpSession
                session = request.getSession();
        Userinfo user =(Userinfo)session.getAttribute("user");
        JsonObject object=new JsonObject();
        PageInfo<Instruments>
                pageInfo= instrumentsService.findInstrumentsAll(page,limit,numbers,user.getId());
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

   /*
    @RequestMapping("/queryInstruments")
    public List<Instruments> queryInstruments(){
        PageInfo<Instruments> pageInfo= instrumentsService.findInstrumentsAll(1,100,null);
        return pageInfo.getList();
    }*/


    @ApiOperation(value = "??????")
    @RequestMapping("/add")
    public R add(@RequestBody Instruments instruments){
        int num= instrumentsService.add(instruments);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("????????????");
        }

    }

    @ApiOperation(value = "??????")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String>
                list= Arrays.asList(ids.split(","));
        //????????????????????????
        for(String id:list){
            instrumentsService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "??????")
    @RequestMapping("/update")
    public R update(@RequestBody Instruments instruments){
        int num= instrumentsService.updateData(instruments);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("????????????");
        }
    }

    @ApiOperation(value = "??????????????????")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "??????"),
            @ApiImplicitParam(name = "pageCount", value = "????????????")
    })
    @GetMapping()
    public IPage<Instruments> findListByPage(@RequestParam Integer page,
                                             @RequestParam Integer pageCount){
        return instrumentsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id??????")
    @GetMapping("{id}")
    public Instruments findById(@PathVariable Long id){
        return instrumentsService.findById(id);
    }

}
