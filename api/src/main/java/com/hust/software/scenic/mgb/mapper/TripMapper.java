package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.MainTrip;
import com.hust.software.scenic.mgb.model.Trip;
import com.hust.software.scenic.mgb.model.TripExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TripMapper {
    int countByExample(TripExample example);

    int deleteByExample(TripExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trip record);

    int insertSelective(Trip record);

    List<Trip> selectByExample(TripExample example);

    Trip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByExample(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);

    @Select({"select name,sum_day as sumDay,count from main_trip main_trip ",
            "left join trip trip on main_trip.id = trip.main_trip_id",
            "where user_id =#{userId} "})
    List<MainTrip> listAllMainTripsByUserId(Integer userId);
}