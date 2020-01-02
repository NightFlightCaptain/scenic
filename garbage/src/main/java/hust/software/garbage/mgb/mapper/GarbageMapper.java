package hust.software.garbage.mgb.mapper;

import hust.software.garbage.dto.SingleGarbage;
import hust.software.garbage.mgb.model.Garbage;
import hust.software.garbage.mgb.model.GarbageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GarbageMapper {
    int countByExample(GarbageExample example);

    int deleteByExample(GarbageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Garbage record);

    int insertSelective(Garbage record);

    List<Garbage> selectByExample(GarbageExample example);

    Garbage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Garbage record, @Param("example") GarbageExample example);

    int updateByExample(@Param("record") Garbage record, @Param("example") GarbageExample example);

    int updateByPrimaryKeySelective(Garbage record);

    int updateByPrimaryKey(Garbage record);

    @Select({"SELECT garbage.id, garbage.NAME, garbage_type.id AS typeId,garbage_type.NAME AS typeName ",
            " FROM garbage LEFT JOIN garbage_type ON garbage.type_id = garbage_type.id",
            " WHERE garbage.name LIKE CONCAT('%',#{name},'%')  "})
    List<SingleGarbage> listGarbageByName(@Param("name") String name);

    @Select({"SELECT garbage.id, garbage.NAME, garbage_type.id AS typeId,garbage_type.NAME AS typeName ",
            " FROM garbage LEFT JOIN garbage_type ON garbage.type_id = garbage_type.id",
            " ORDER BY  rand() LIMIT  10"})
    List<SingleGarbage> listRandomGarbage();

    @Select({"SELECT garbage.id, garbage.NAME, garbage_type.id AS typeId,garbage_type.NAME AS typeName ",
            " FROM garbage LEFT JOIN garbage_type ON garbage.type_id = garbage_type.id",
            " WHERE garbage_type.id = #{typeId} ",
            " ORDER BY  garbage.id LIMIT #{start},#{size}"})
    List<SingleGarbage> listGarbagesByTypeWithPage(@Param("typeId") Integer typeId, @Param("start") Integer start, @Param("size") Integer size);
}