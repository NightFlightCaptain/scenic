package com.hust.software.scenic.mgb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Mark implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "景点id")
    private Integer scenicId;

    @ApiModelProperty(value = "打卡时间")
    private Date markDate;

    @ApiModelProperty(value = "打卡名次")
    private Integer rank;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
        sb.append(", userId=").append(userId);
        sb.append(", scenicId=").append(scenicId);
        sb.append(", markDate=").append(markDate);
        sb.append(", rank=").append(rank);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}