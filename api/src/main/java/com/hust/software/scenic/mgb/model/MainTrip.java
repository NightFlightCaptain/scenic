package com.hust.software.scenic.mgb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class MainTrip implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "总计天数")
    private Integer sumDay;

    @ApiModelProperty(value = "使用次数/热度")
    private Integer count;

    @ApiModelProperty(value = "行程名")
    private String name;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sumDay=").append(sumDay);
        sb.append(", count=").append(count);
        sb.append(", name=").append(name);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}