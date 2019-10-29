package com.hust.software.scenic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.model.Scenic;
import com.hust.software.scenic.service.ScenicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags="ScenicController",description="景点接口")
public class ScenicController {

	//java editor content advance
	@Autowired
	private ScenicService scenicService;
	
	/**
	 * 增加景点信息接口
	 * 将景点信息通过post表单发送回来，可自动填充
	 * @param scenic
	 * @return
	 */
	@PostMapping("addscenic")
	@ApiOperation("增加一条景点")
	public CommonResult addScenic(Scenic scenic) {
		return scenicService.addScenic(scenic);
	}
	
	/**
	 * 删除景点信息
	 * @param ScenicId
	 * @return
	 */
	@DeleteMapping("delscenic")
	@ApiOperation("删除一条景点")
	public CommonResult delScenic(@RequestParam("ScenicId")@ApiParam("景点ID") Integer ScenicId) {
		return scenicService.delScenicById(ScenicId);
	}
	
	/**
	 * 更新景点信息
	 * @param scenic
	 * @return
	 */
	@PutMapping("updscenic")
	@ApiOperation("更新一条景点信息")
	public CommonResult updScenic(Scenic scenic) {
		return scenicService.updScenicById(scenic);
	}
	
	/**
	 * 查询单挑景点的信息
	 * @param ScenicId
	 * @return
	 */
	@GetMapping("selscenic")
	@ApiOperation("查询一条单个景点信息")
	public CommonResult selScenic(@RequestParam("ScenicId")@ApiParam("景点id")Integer ScenicId) {
		return scenicService.selScenicById(ScenicId);
	}
	
	/**
	 * 可模糊查询的景点分页功能
	 * @param ScenicName
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@GetMapping("selsceniclist")
	@ApiOperation("可模糊分页查询景点列表")
	public CommonResult selScenicList(@RequestParam(value = "ScenicName",required = false)@ApiParam("景点名称")String ScenicName,
									  @RequestParam(value = "pageNow",defaultValue = "1")@ApiParam("当前页数")Integer pageNow,
									  @RequestParam(value = "pageSize",defaultValue = "10")@ApiParam("显示条数")Integer pageSize) {
		return scenicService.selScenicListByPage(ScenicName, pageNow, pageSize);
	}
}
