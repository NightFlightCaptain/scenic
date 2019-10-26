package com.hust.software.scenic.service;

import com.hust.software.scenic.common.CommonResult;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 10:41
 */
public interface UserTripService {
    /**
     * 为某用户增加一次预设的行程
     * @param mainTripId
     * @param userId
     * @return
     */
    CommonResult addUserTrip(Integer mainTripId, Integer userId);

    /**
     * 获取用户的全部行程id
     * @param userId
     * @return maintripids
     */
    CommonResult listAllMainTripsByUserId(Integer userId);
}
