package com.hust.software.scenic.controller;

import com.hust.software.scenic.dto.TripDto;
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
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private UserTripService userTripService;

    @ApiOperation("获取一次行程的所有景点")
    @GetMapping("mainTrip")
    public TripDto getMainTrip(@RequestParam("mainTripId")@ApiParam("行程id") Integer mainTripId){
        TripDto tripDto = tripService.getMainTrip(mainTripId);
        return tripDto;
    }

    @PostMapping("addUserTrip")
    public void addMyTrip(@RequestParam("mainTripId")Integer mainTripId,
                          @RequestParam("userId")Integer userId){
        userTripService.addUserTrip(mainTripId,userId);
    }

    @ApiOperation("获取某用户的全部行程id")
    @GetMapping("getUserTrip")
    public List<Integer> getUserTrip(@RequestParam("userId")Integer userId){
        List<Trip> trips = userTripService.getUserTrip(userId);
        List<Integer> mainTripIds= trips.stream().map(Trip::getMainTripId).collect(Collectors.toList());
        return mainTripIds;
    }
}
