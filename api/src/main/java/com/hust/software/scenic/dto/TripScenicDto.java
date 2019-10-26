package com.hust.software.scenic.dto;

import com.hust.software.scenic.mgb.model.Scenic;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:42
 */
public class TripScenicDto {

    private Integer id;
    private String name;

    private String introduction;

    private String openTime;

    private BigDecimal price;

    private Date suggestedTime;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String photoUrl;

    public TripScenicDto() {
    }

    public TripScenicDto(Scenic scenic){
        this.setId(scenic.getId());
        this.setName(scenic.getName());
        this.setIntroduction(scenic.getIntroduction());
        this.setLatitude(scenic.getLatitude());
        this.setLongitude(scenic.getLongitude());
        this.setOpenTime(scenic.getOpenTime());
        this.setPrice(scenic.getPrice());
        this.setSuggestedTime(scenic.getSuggestedTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getSuggestedTime() {
        return suggestedTime;
    }

    public void setSuggestedTime(Date suggestedTime) {
        this.suggestedTime = suggestedTime;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
