package com.hust.software.scenic.dto;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:32
 */
public class TripDto {
    private int sumDay;
    private int count;
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
