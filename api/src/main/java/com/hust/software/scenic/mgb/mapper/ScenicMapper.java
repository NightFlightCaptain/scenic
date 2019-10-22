package com.hust.software.scenic.mgb.mapper;

import com.hust.software.scenic.mgb.model.Scenic;
import com.hust.software.scenic.mgb.model.ScenicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScenicMapper {
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
}