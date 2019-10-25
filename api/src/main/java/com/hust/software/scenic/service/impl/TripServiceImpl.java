package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.dto.TripDto;
import com.hust.software.scenic.dto.TripScenicDto;
import com.hust.software.scenic.mgb.mapper.MainTripMapper;
import com.hust.software.scenic.mgb.mapper.ScenicMapper;
import com.hust.software.scenic.mgb.mapper.SingleTripMapper;
import com.hust.software.scenic.mgb.model.MainTrip;
import com.hust.software.scenic.mgb.model.SingleTrip;
import com.hust.software.scenic.mgb.model.SingleTripExample;
import com.hust.software.scenic.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:18
 */
@Service
public class TripServiceImpl implements TripService {
    @Autowired
    SingleTripMapper singleTripMapper;

    @Autowired
    MainTripMapper mainTripMapper;

    @Autowired
    ScenicMapper scenicMapper;

    @Override
    public void addMainTrip(List<String> scenicOrders) {
        int sumDay = scenicOrders.size();
        MainTrip mainTrip = new MainTrip();
        mainTrip.setSumDay(sumDay);
        int mainTripId = mainTripMapper.insertSelective(mainTrip);

        for (String scenicOrder : scenicOrders) {
            addSingleTrip(mainTripId, scenicOrder);
        }
    }

    private void addSingleTrip(int mainTripId, String scenicOrder) {
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
    public TripDto getMainTrip(int mainTripId) {
        TripDto tripDto = new TripDto();
        MainTrip mainTrip = mainTripMapper.selectByPrimaryKey(mainTripId);
        if (mainTrip == null) {
            return null;
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
            List<TripScenicDto> singleTripScenics = new ArrayList<>();
            //求出每个singleTrip的景点
            Arrays.stream(singleTrip.getScenicOrder().split(","))
                    .forEachOrdered(scenicId -> singleTripScenics.add(scenicMapper.listTripScenic(Integer.valueOf(scenicId))));
            mainTrips.add(singleTripScenics);
        }
        tripDto.setSingleTrips(mainTrips);
        return tripDto;
    }
}
