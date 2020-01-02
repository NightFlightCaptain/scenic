package hust.software.garbage.controller;

import hust.software.garbage.common.CommonResult;
import hust.software.garbage.service.GarbageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2020/1/2 9:54
 */
@RestController
@Api(tags="GarbageController",description="垃圾分类功能接口")
public class GarbageController {
    @Autowired
    private GarbageService garbageService;

    @GetMapping("search")
    @ApiOperation("搜索")
    public CommonResult searchGarbage(@RequestParam("name")@ApiParam("垃圾名称") String name){
        if (name == null || "".equals(name)){
            return CommonResult.failed("请输入垃圾名称");
        }
        return garbageService.listGarbagesByName(name);
    }

    @GetMapping("getGarbagesByType")
    @ApiOperation("根据类别筛选垃圾,没有分页功能,可能会造成swagger卡顿，但是直接在浏览器中输入http://localhost:8004/getGarbagesByType?typeId=1是没有问题的")
    public CommonResult getGarbagesByType(@RequestParam("typeId")@ApiParam("垃圾类别id") Integer typeId){
        return garbageService.listGarbagesByType(typeId);
    }

    @GetMapping("getGarbagesByTypeWithPage")
    @ApiOperation("根据类别筛选垃圾，带有分页功能")
    public CommonResult getGarbagesByTypeWithPage(@RequestParam("typeId")@ApiParam("垃圾类别id") Integer typeId,
                                                  @RequestParam(value = "page",defaultValue = "1")@ApiParam("当前页数")Integer page,
                                                  @RequestParam(value = "size",defaultValue = "10")@ApiParam("显示条数")Integer size){
        return garbageService.listGarbagesByTypeWithPage(typeId, page, size);
    }

    @GetMapping("getRandomGarbages")
    @ApiOperation("随机获取10条垃圾信息")
    public CommonResult getRandomGarbages(){
        return garbageService.listRandomGarbages();
    }
}