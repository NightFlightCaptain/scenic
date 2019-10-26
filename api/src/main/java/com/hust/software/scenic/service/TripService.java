package com.hust.software.scenic.service;

import com.hust.software.scenic.common.CommonResult;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:17
 */
public interface TripService {
    CommonResult addMainTrip(List<List<Integer>> scenicOrders);

    CommonResult getMainTrip(int mainTripId);
}
