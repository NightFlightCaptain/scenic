package com.hust.software.scenic.service;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.model.Scenic;

/**
 * 
 * @author YCY
 *
 */
public interface ScenicService {
	
	/**
	 * 新增景点信息
	 * @param scenic
	 * @return
	 */
	CommonResult addScenic(Scenic scenic);
	
	/**
	 * 根据id删除景点信息
	 * @param scenicId
	 * @return
	 */
	CommonResult delScenicById(Integer scenicId);
	
	/**
	 * 修改景点信息
	 * @param scenic
	 * @return
	 */
	CommonResult updScenicById(Scenic scenic);
	
	/**
	 * 查询单条景点信息
	 * @param scenic
	 * @return
	 */
	CommonResult selScenicById(Integer scenic);
	

	/**
	 * 有没有景点名称模糊查询-有的
	 * 分页查询景点信息
	 * @param pageNow 当前页
	 * @param pageSize 页面展示条数
	 * @return
	 */
	CommonResult selScenicListByPage(String name,Integer pageNow,Integer pageSize);
	
}
