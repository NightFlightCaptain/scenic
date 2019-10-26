package com.hust.software.scenic.dto;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 15:55
 */
public class MainTripDto {
    private String name;
    private Integer sumDay;
    private Integer count;
    private String photoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSumDay() {
        return sumDay;
    }

    public void setSumDay(Integer sumDay) {
        this.sumDay = sumDay;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
