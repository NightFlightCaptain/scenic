package com.hust.software.scenic.dto;

import com.hust.software.scenic.mgb.model.Scenic;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author: 小栗旬
 * @Date: 2019/10/25 9:42
 */
public class TripScenicDto {

    private Integer id;
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "介绍")
    private String introduction;

    @ApiModelProperty(value = "开放时间")
    private String openTime;

    @ApiModelProperty(value = "门票价格")
    private BigDecimal price;

    @ApiModelProperty(value = "建议游玩时间")
    private String suggestedTime;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "维度")
    private BigDecimal latitude;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "评分")
    private Integer score;

    @ApiModelProperty(value = "图片链接")
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
        this.setAddress(scenic.getAddress());
        this.setScore(scenic.getScore());
        this.setPhone(scenic.getPhone());
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

    public String getSuggestedTime() {
        return suggestedTime;
    }

    public void setSuggestedTime(String suggestedTime) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
