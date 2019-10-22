package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.Trip;
import com.hust.software.scenic.mgb.model.TripExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}