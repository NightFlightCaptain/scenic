package com.hust.software.scenic.service;

import com.hust.software.scenic.dto.TripDto;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:17
 */
public interface TripService {
    void addMainTrip(List<String> scenicOrders);

    TripDto getMainTrip(int mainTripId);
}
