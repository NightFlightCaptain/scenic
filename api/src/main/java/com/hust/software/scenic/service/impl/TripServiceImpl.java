package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.dto.TripDto;
import com.hust.software.scenic.dto.TripScenicDto;
import com.hust.software.scenic.mgb.mapper.MainTripMapper;
import com.hust.software.scenic.mgb.mapper.ScenicMapper;
import com.hust.software.scenic.mgb.mapper.SingleTripMapper;
import com.hust.software.scenic.mgb.model.MainTrip;
import com.hust.software.scenic.mgb.model.MainTripExample;
import com.hust.software.scenic.mgb.model.SingleTrip;
import com.hust.software.scenic.mgb.model.SingleTripExample;
import com.hust.software.scenic.service.TripService;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:18
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    SingleTripMapper singleTripMapper;

    @Autowired
    MainTripMapper mainTripMapper;

    @Autowired
    ScenicMapper scenicMapper;

    @Override
    public CommonResult addMainTrip(String name,List<List<Integer>> scenicOrders) {
        int sumDay = scenicOrders.size();
        MainTrip mainTrip = new MainTrip();
        mainTrip.setName(name);
        mainTrip.setSumDay(sumDay);
        mainTripMapper.insertSelective(mainTrip);

        for (List<Integer> scenicOrder : scenicOrders) {
            addSingleTrip(mainTrip.getId(), StringUtils.join(scenicOrder.toArray(),","));
        }
        return CommonResult.success("成功添加");
    }

    private void addSingleTrip(Integer mainTripId, String scenicOrder) {
        SingleTrip singleTrip = new SingleTrip();
        singleTrip.setMainTripId(mainTripId);
        singleTrip.setScenicOrder(scenicOrder);
        singleTripMapper.insertSelective(singleTrip);
    }

    /**
     * 获取一个总行程
     * @param mainTripId 总行程id
     * @return 总行程下面的单日行程的每日行程的景点信息
     */
    @Override
    public CommonResult getMainTrip(int mainTripId) {
        TripDto tripDto = new TripDto();
        MainTrip mainTrip = mainTripMapper.selectByPrimaryKey(mainTripId);
        if (mainTrip == null) {
            return CommonResult.failed("错误的id");
        }

        tripDto.setCount(mainTrip.getCount());
        tripDto.setSumDay(mainTrip.getSumDay());

        //求出所有的singleTrip
        SingleTripExample singleTripExample = new SingleTripExample();
        SingleTripExample.Criteria criteria = singleTripExample.createCriteria();
        criteria.andMainTripIdEqualTo(mainTripId);
        List<SingleTrip> singleTrips = singleTripMapper.selectByExample(singleTripExample);

        List<List<TripScenicDto>> mainTrips = new LinkedList<>();
        for (SingleTrip singleTrip : singleTrips) {
            List<TripScenicDto> scenicsOneDay = new ArrayList<>();
            //求出每个singleTrip的景点
            Arrays.stream(singleTrip.getScenicOrder().split(","))
                    .forEachOrdered(scenicId -> scenicsOneDay.add(scenicMapper.listTripScenic(Integer.valueOf(scenicId))));
            mainTrips.add(scenicsOneDay);
        }
        tripDto.setSingleTrips(mainTrips);
        return CommonResult.success(tripDto);
    }

    @Override
    public CommonResult listAllMainTrips(){
        MainTripExample mainTripExample = new MainTripExample();
        MainTripExample.Criteria criteria = mainTripExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        List<MainTrip> mainTrips = mainTripMapper.selectByExample(mainTripExample);
        return CommonResult.success(mainTrips);
    }
}
