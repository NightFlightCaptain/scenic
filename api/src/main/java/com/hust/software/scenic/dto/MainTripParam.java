package com.hust.software.scenic.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 16:37
 */
public class MainTripParam {
    @ApiModelProperty(value = "名称",example = "两日游")
    private String name;
    @ApiModelProperty(value = "名称",example = "[[1],[2,3]]")
    private List<List<Integer>> scenicOrders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Integer>> getScenicOrders() {
        return scenicOrders;
    }

    public void setScenicOrders(List<List<Integer>> scenicOrders) {
        this.scenicOrders = scenicOrders;
    }
}
