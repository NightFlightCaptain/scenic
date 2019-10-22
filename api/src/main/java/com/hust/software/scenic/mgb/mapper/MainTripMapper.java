package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.MainTrip;
import com.hust.software.scenic.mgb.model.MainTripExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MainTripMapper {
    int countByExample(MainTripExample example);

    int deleteByExample(MainTripExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MainTrip record);

    int insertSelective(MainTrip record);

    List<MainTrip> selectByExample(MainTripExample example);

    MainTrip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MainTrip record, @Param("example") MainTripExample example);

    int updateByExample(@Param("record") MainTrip record, @Param("example") MainTripExample example);

    int updateByPrimaryKeySelective(MainTrip record);

    int updateByPrimaryKey(MainTrip record);
}