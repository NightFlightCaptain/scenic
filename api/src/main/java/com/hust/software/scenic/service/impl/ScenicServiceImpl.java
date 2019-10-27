package com.hust.software.scenic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.mapper.ScenicMapper;
import com.hust.software.scenic.mgb.model.Scenic;
import com.hust.software.scenic.mgb.model.ScenicExample;
import com.hust.software.scenic.service.ScenicService;

@Service
public class ScenicServiceImpl implements ScenicService {

	@Autowired
	private ScenicMapper scenicMapper;
	
	@Override
	public CommonResult addScenic(Scenic scenic) {
		boolean flag = scenicMapper.insert(scenic)>=1;
		if(flag) {
			return CommonResult.success("景点信息插入成功", scenic);
		}else {
			return CommonResult.failed("景点信息插入失败");
		}
	}

	@Override
	public CommonResult delScenicById(Integer scenicId) {
		boolean flag = scenicMapper.deleteByPrimaryKey(scenicId)>=1;
		if(flag) {
			return CommonResult.success("景点信息删除成功");
		}else {
			return CommonResult.failed("景点信息删除失败");
		}
	}

	@Override
	public CommonResult updScenicById(Scenic scenic) {
		boolean flag = scenicMapper.updateByPrimaryKey(scenic)>=1;
		if(flag) {
			return CommonResult.success("景点信息更新成功");
		}else {
			return CommonResult.failed("景点信息更新失败");
		}
	}

	@Override
	public CommonResult selScenicById(Integer scenicId) {
		Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
		if(scenic==null) {
			return CommonResult.failed("该景点信息查询失败");
		}else {
			return CommonResult.success("该景点信息查询成功", scenic);
		}
	}

	@Override
	public CommonResult selScenicListByPage(String name,Integer pageNow, Integer pageSize) {
		ScenicExample se = new ScenicExample();
		se.setPageNow((pageNow-1)*pageSize);
		se.setPageSize(pageSize);
		ScenicExample.Criteria criteria = se.createCriteria();
		criteria.andIsDeletedEqualTo(false);
		if(!name.equals("") && name!=null) {
			criteria.andNameLike("%"+name+"%");
		}
		System.out.println("景点名称"+name);
		List<Scenic> scenicList = scenicMapper.selectByExample(se);
		if(scenicList.size()>0) {
			return CommonResult.success("景点信息查询成功", scenicList);
		}else if(scenicList.size()==0){
			return CommonResult.success("没有查询到您要搜索的景点信息");
		}else {
			return CommonResult.failed("景点信息查询失败");
		}
	}

}
