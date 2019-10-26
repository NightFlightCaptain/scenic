package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.dto.MainTripParam;
import com.hust.software.scenic.service.TripService;
import com.hust.software.scenic.service.UserTripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:17
 */
@Api(tags = "TripController", description = "行程接口")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserTripService userTripService;

    @ApiOperation("获取一次行程的所有景点")
    @GetMapping("mainTrip")
    public CommonResult getMainTrip(@RequestParam("mainTripId") @ApiParam("行程id") Integer mainTripId) {
        return tripService.getMainTrip(mainTripId);
    }

    @ApiOperation("为某用户增加一次预设的行程")
    @PostMapping("addUserTrip")
    public CommonResult addMyTrip(@RequestParam("mainTripId") @ApiParam("行程id") Integer mainTripId,
                                  @RequestParam("userId") @ApiParam("用户id") Integer userId) {
        return userTripService.addUserTrip(mainTripId, userId);
    }

    @ApiOperation("获取某用户的全部行程")
    @GetMapping("getUserTrip")
    public CommonResult getUserTrip(@RequestParam("userId") Integer userId) {
        return userTripService.listAllMainTripsByUserId(userId);
    }

    @ApiOperation("获取全部的预设行程")
    @GetMapping("getAllTrips")
    public CommonResult listAllTrip(){
        return tripService.listAllMainTrips();
    }

    @ApiOperation("增加行程记录")
    @PostMapping("addTrip")
    public CommonResult addTrip(@RequestBody @ApiParam("该参数为一个大数组，大数据里存放的是一个小数组，小数组里面存放的按顺序的景点id")MainTripParam mainTripParam) {
        return tripService.addMainTrip(mainTripParam.getName(),mainTripParam.getScenicOrders());
    }
}
