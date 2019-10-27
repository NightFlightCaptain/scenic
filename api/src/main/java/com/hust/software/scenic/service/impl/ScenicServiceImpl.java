package com.hust.software.scenic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.mapper.PictureMapper;
import com.hust.software.scenic.mgb.mapper.PictureScenicMapper;
import com.hust.software.scenic.mgb.mapper.ScenicMapper;
import com.hust.software.scenic.mgb.model.Picture;
import com.hust.software.scenic.mgb.model.PictureScenic;
import com.hust.software.scenic.mgb.model.PictureScenicExample;
import com.hust.software.scenic.mgb.model.Scenic;
import com.hust.software.scenic.mgb.model.ScenicExample;
import com.hust.software.scenic.service.ScenicService;

@Service
public class ScenicServiceImpl implements ScenicService {

	@Autowired
	private ScenicMapper scenicMapper;
	
	@Autowired
	private PictureScenicMapper pictureScenicMapper;
	
	@Autowired
	private PictureMapper pictureMapper;
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

	
	/**
	 * 查询单个景点的信息，并将景点的图片找到后一起封装返回
	 */
	@Override
	public CommonResult selScenicById(Integer scenicId) {
		Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
		
		if(scenic==null) {
			return CommonResult.failed("该景点信息查询失败");
		}
		
		List<Picture> list = new ArrayList<Picture>();
		Map<String,Object> map = new HashMap<>();
		PictureScenicExample pse = new PictureScenicExample();
		PictureScenicExample.Criteria criteria = pse.createCriteria();
		criteria.andScenicIdEqualTo(scenicId);
		List<PictureScenic> pictureScenicList = pictureScenicMapper.selectByExample(pse);
		
		for (PictureScenic p:pictureScenicList) {
			Picture picture = pictureMapper.selectByPrimaryKey(p.getPictureId());
			list.add(picture);
		}
		map.put("scenic", scenic);
		map.put("scenicpicture", list);

		return CommonResult.success("该景点信息查询成功", map);
	}
	
	/**
	 * 查询景点列表及其对应的图片
	 */
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
		//做判断
		if(scenicList.size()==0){
			return CommonResult.success("没有查询到您要搜索的景点信息");
		}else if(scenicList.size()<0){
			return CommonResult.failed("景点信息查询失败");
		}
		List<Map<String,Object>> list = new ArrayList<>();
		for(Scenic sc:scenicList) {
			Map<String,Object> map = new HashMap<String, Object>();
			PictureScenicExample pse = new PictureScenicExample();
			PictureScenicExample.Criteria pCriteria = pse.createCriteria();
			pCriteria.andScenicIdEqualTo(sc.getId());
			pCriteria.andIsMajorEqualTo(true);
			pCriteria.andIsDeletedEqualTo(false);
			//按照预定只有一条数据
			List<PictureScenic> picSceList = pictureScenicMapper.selectByExample(pse);
			//做判断
			if(picSceList.size()<=0) {
				return CommonResult.failed("景点图片信息查询失败");
			}
			Picture picture = pictureMapper.selectByPrimaryKey(picSceList.get(0).getPictureId());
			map.put("scenic", sc);
			map.put("scenicpic", picture);
			list.add(map);
		}
		return CommonResult.success("景点信息查询成功", list);
	}

}
