package com.hust.software.scenic.service;

import com.hust.software.scenic.mgb.model.Trip;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 10:41
 */
public interface UserTripService {
    void addUserTrip(Integer mainTripId, Integer userId);

    List<Trip> getUserTrip(Integer userId);
}
