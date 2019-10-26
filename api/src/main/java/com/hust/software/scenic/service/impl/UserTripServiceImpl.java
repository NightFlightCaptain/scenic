package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.mapper.MainTripMapper;
import com.hust.software.scenic.mgb.mapper.TripMapper;
import com.hust.software.scenic.mgb.model.MainTrip;
import com.hust.software.scenic.mgb.model.Trip;
import com.hust.software.scenic.mgb.model.TripExample;
import com.hust.software.scenic.service.UserTripService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 10:41
 */
@Service
public class UserTripServiceImpl implements UserTripService {
    @Autowired
    private TripMapper tripMapper;
    @Autowired
    private MainTripMapper mainTripMapper;


    @Override
    public CommonResult addUserTrip(Integer mainTripId, Integer userId){
        if (mainTripMapper.selectByPrimaryKey(mainTripId)==null){
            return CommonResult.failed("错误的主键");
        }
        Trip trip = new Trip();
        trip.setMainTripId(mainTripId);
        trip.setUserId(userId);
        tripMapper.insertSelective(trip);
        return CommonResult.success("成功添加");
    }

    /**
     * 获取某个用户的全部行程id
     * @param userId
     * @return mainTripIds 行程的id
     */
    @Override
    public CommonResult listAllMainTripsByUserId(Integer userId){
        List<MainTrip> trips = tripMapper.listAllMainTripsByUserId(userId);
        return CommonResult.success(trips);
    }
}
