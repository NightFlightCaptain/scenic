package com.hust.software.scenic.mgb.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class PictureScenic implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "图片id")
    private Integer pictureId;

    @ApiModelProperty(value = "景点id")
    private Integer scenicId;

    @ApiModelProperty(value = "是否首要展示图")
    private Boolean isMajor;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }

    public Boolean getIsMajor() {
        return isMajor;
    }

    public void setIsMajor(Boolean isMajor) {
        this.isMajor = isMajor;
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
        sb.append(", pictureId=").append(pictureId);
        sb.append(", scenicId=").append(scenicId);
        sb.append(", isMajor=").append(isMajor);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}