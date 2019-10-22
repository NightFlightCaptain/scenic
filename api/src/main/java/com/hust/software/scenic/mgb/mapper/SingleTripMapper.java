package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.SingleTrip;
import com.hust.software.scenic.mgb.model.SingleTripExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingleTripMapper {
    int countByExample(SingleTripExample example);

    int deleteByExample(SingleTripExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SingleTrip record);

    int insertSelective(SingleTrip record);

    List<SingleTrip> selectByExample(SingleTripExample example);

    SingleTrip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SingleTrip record, @Param("example") SingleTripExample example);

    int updateByExample(@Param("record") SingleTrip record, @Param("example") SingleTripExample example);

    int updateByPrimaryKeySelective(SingleTrip record);

    int updateByPrimaryKey(SingleTrip record);
}