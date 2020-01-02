package hust.software.garbage.mgb.mapper;

import hust.software.garbage.mgb.model.GarbageType;
import hust.software.garbage.mgb.model.GarbageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarbageTypeMapper {
    int countByExample(GarbageTypeExample example);

    int deleteByExample(GarbageTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GarbageType record);

    int insertSelective(GarbageType record);

    List<GarbageType> selectByExample(GarbageTypeExample example);

    GarbageType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    int updateByExample(@Param("record") GarbageType record, @Param("example") GarbageTypeExample example);

    int updateByPrimaryKeySelective(GarbageType record);

    int updateByPrimaryKey(GarbageType record);
}