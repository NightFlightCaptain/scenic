package hust.software.garbage.mgb.mapper;

import hust.software.garbage.mgb.model.SearchAccount;
import hust.software.garbage.mgb.model.SearchAccountExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SearchAccountMapper {
    int countByExample(SearchAccountExample example);

    int deleteByExample(SearchAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchAccount record);

    int insertSelective(SearchAccount record);

    List<SearchAccount> selectByExample(SearchAccountExample example);

    SearchAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchAccount record, @Param("example") SearchAccountExample example);

    int updateByExample(@Param("record") SearchAccount record, @Param("example") SearchAccountExample example);

    int updateByPrimaryKeySelective(SearchAccount record);

    int updateByPrimaryKey(SearchAccount record);

    /**
     * 给某个类别查询次数+1
     * @param typeName 类别名称
     * @return
     */
    @Update("UPDATE search_account AS search SET search.account =  search.account +1 WHERE search.type_name =#{typeName}")
    int addAccount(@Param("typeName") String typeName);

}