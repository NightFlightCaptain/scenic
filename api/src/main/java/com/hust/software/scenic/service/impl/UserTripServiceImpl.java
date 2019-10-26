package com.hust.software.scenic.service.impl;

import com.hust.software.scenic.mgb.mapper.TripMapper;
import com.hust.software.scenic.mgb.model.Trip;
import com.hust.software.scenic.mgb.model.TripExample;
import com.hust.software.scenic.service.UserTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 10:41
 */
@Service
public class UserTripServiceImpl implements UserTripService {
    @Autowired
    private TripMapper tripMapper;

    @Override
    public void addUserTrip(Integer mainTripId,Integer userId){
        Trip trip = new Trip();
        trip.setMainTripId(mainTripId);
        trip.setUserId(userId);
        tripMapper.insertSelective(trip);
    }

    @Override
    public List<Trip> getUserTrip(Integer userId){
        TripExample tripExample = new TripExample();
        TripExample.Criteria criteria = tripExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDeletedEqualTo(false);
        List<Trip> trips = tripMapper.selectByExample(tripExample);
        return trips;
    }
}
