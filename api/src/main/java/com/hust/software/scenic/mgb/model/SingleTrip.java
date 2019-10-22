package com.hust.software.scenic.mgb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SingleTrip implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "主行程")
    private Integer mainTripId;

    @ApiModelProperty(value = "景点路线")
    private String scenicOrder;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainTripId() {
        return mainTripId;
    }

    public void setMainTripId(Integer mainTripId) {
        this.mainTripId = mainTripId;
    }

    public String getScenicOrder() {
        return scenicOrder;
    }

    public void setScenicOrder(String scenicOrder) {
        this.scenicOrder = scenicOrder;
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
        sb.append(", mainTripId=").append(mainTripId);
        sb.append(", scenicOrder=").append(scenicOrder);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}