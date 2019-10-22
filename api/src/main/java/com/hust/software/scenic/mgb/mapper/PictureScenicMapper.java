package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.PictureScenic;
import com.hust.software.scenic.mgb.model.PictureScenicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PictureScenicMapper {
    int countByExample(PictureScenicExample example);

    int deleteByExample(PictureScenicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PictureScenic record);

    int insertSelective(PictureScenic record);

    List<PictureScenic> selectByExample(PictureScenicExample example);

    PictureScenic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PictureScenic record, @Param("example") PictureScenicExample example);

    int updateByExample(@Param("record") PictureScenic record, @Param("example") PictureScenicExample example);

    int updateByPrimaryKeySelective(PictureScenic record);

    int updateByPrimaryKey(PictureScenic record);
}