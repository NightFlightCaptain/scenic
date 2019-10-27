package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.dto.TripScenicDto;
import com.hust.software.scenic.mgb.model.Scenic;
import com.hust.software.scenic.mgb.model.ScenicExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScenicMapper {

    String TABLE_NAME = " scenic ";
    String INSERT_FILEDS = " name,introduction,open_time,price,suggested_time,longitude,latitude,photoUrl ";
    String SELECT_FILEDS = " id," + INSERT_FILEDS;


    int countByExample(ScenicExample example);

    int deleteByExample(ScenicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Scenic record);

    int insertSelective(Scenic record);

    List<Scenic> selectByExample(ScenicExample example);

    Scenic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scenic record, @Param("example") ScenicExample example);

    int updateByExample(@Param("record") Scenic record, @Param("example") ScenicExample example);

    int updateByPrimaryKeySelective(Scenic record);

    int updateByPrimaryKey(Scenic record);

    @Select({"SELECT scenic.id AS id,name,introduction,open_time,price,suggested_time,longitude,latitude,address,score,phone,pic.url AS photoUrl " +
            " FROM ", TABLE_NAME, "scenic " +
            "LEFT JOIN picture_scenic pic_scenic ON scenic.id = pic_scenic.scenic_id " +
            "LEFT JOIN picture pic ON pic_scenic.picture_id = pic.id " +
            "WHERE pic_scenic.is_major = 1 AND pic_scenic.is_deleted =0 AND scenic.is_deleted =0 AND pic.is_deleted =0" +
            " AND scenic.id = #{scenicId} "
    })
    TripScenicDto listTripScenic(int scenicId);
}