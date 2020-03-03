package hust.software.garbage.mgb.mapper;

import hust.software.garbage.mgb.model.GarbageType;
import hust.software.garbage.mgb.model.GarbageTypeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("SELECT id from garbage_type where name = #{typeName} ")
    int getIdByTypeName(@Param("typeName")String typeName);
}