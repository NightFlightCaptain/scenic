package com.hust.software.scenic.controller;

import com.hust.software.scenic.common.CommonResult;
import com.hust.software.scenic.mgb.model.Trip;
import com.hust.software.scenic.service.TripService;
import com.hust.software.scenic.service.UserTripService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:17
 */
@Api(tags = "TripController", description = "商品品牌管理")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserTripService userTripService;

    @ApiOperation("获取一次行程的所有景点")
    @GetMapping("mainTrip")
    public CommonResult getMainTrip(@RequestParam("mainTripId")@ApiParam("行程id") Integer mainTripId){
        return tripService.getMainTrip(mainTripId);
    }

    @ApiOperation("为某用户增加一次已有的行程")
    @PostMapping("addUserTrip")
    public void addMyTrip(@RequestParam("mainTripId")@ApiParam("行程id") Integer mainTripId,
                          @RequestParam("userId")@ApiParam("用户id") Integer userId){
        userTripService.addUserTrip(mainTripId,userId);
    }

    @ApiOperation("获取某用户的全部行程id")
    @GetMapping("getUserTrip")
    public List<Integer> getUserTrip(@RequestParam("userId")Integer userId){
        List<Trip> trips = userTripService.getUserTrip(userId);
        List<Integer> mainTripIds= trips.stream().map(Trip::getMainTripId).collect(Collectors.toList());
        return mainTripIds;
    }

    @ApiOperation("增加行程记录")
    @PostMapping("addTrip")
    public CommonResult addTrip(@RequestParam("scenicOrders")@ApiParam("该参数为一个大数组，大数据里存放的是一个小数组，小数组里面存放的按顺序的景点id")List<List<Integer>> scenicOrders){
        return tripService.addMainTrip(scenicOrders);
    }
}
