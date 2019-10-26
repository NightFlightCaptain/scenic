package com.hust.software.scenic.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:32
 */
public class TripDto {
    @ApiModelProperty(value = "总计天数")
    private int sumDay;

    @ApiModelProperty(value = "使用次数/热度")
    private int count;

    @ApiModelProperty(value = "景点列表，一个list表示一天的景点")
    private List<List<TripScenicDto>> singleTrips;

    public int getSumDay() {
        return sumDay;
    }

    public void setSumDay(int sumDay) {
        this.sumDay = sumDay;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<List<TripScenicDto>> getSingleTrips() {
        return singleTrips;
    }

    public void setSingleTrips(List<List<TripScenicDto>> singleTrips) {
        this.singleTrips = singleTrips;
    }
}
