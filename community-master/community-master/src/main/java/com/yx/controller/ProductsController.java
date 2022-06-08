package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Products;
import com.yx.service.IProductsService;
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
@RequestMapping("/products")
public class ProductsController {
    private Logger
            log = LoggerFactory.getLogger(getClass());

    @Resource
    private IProductsService
            productsService;


    @RequestMapping("/queryProductsAll")
    public JsonObject queryProductsAll(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "15") Integer limit,
                                       String numbers){
        JsonObject
                object=new JsonObject();
        PageInfo<Products>
                pageInfo= productsService.findProductsAll(page,limit,numbers);
        object.setCode(0);
        object.setMsg("ok");
        object.setCount(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @RequestMapping("/queryProducts")
    public List<Products> queryProducts(){
        PageInfo<Products> pageInfo= productsService.findProductsAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Products products){
        int num= productsService.add(products);
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
            productsService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Products products){
        int num= productsService.updateData(products);
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
    public IPage<Products> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return productsService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Products findById(@PathVariable Long id){
        return productsService.findById(id);
    }
}
