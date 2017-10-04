package cn.zx.dao;

import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyNewsMapper {
    long countByExample(CompanyNewsExample example);

    int deleteByExample(CompanyNewsExample example);

    int deleteByPrimaryKey(Integer new_id);

    int insert(CompanyNews record);

    int insertSelective(CompanyNews record);

    List<CompanyNews> selectByExampleWithBLOBs(CompanyNewsExample example);

    List<CompanyNews> selectByExample(CompanyNewsExample example);

    CompanyNews selectByPrimaryKey(Integer new_id);

    int updateByExampleSelective(@Param("record") CompanyNews record, @Param("example") CompanyNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") CompanyNews record, @Param("example") CompanyNewsExample example);

    int updateByExample(@Param("record") CompanyNews record, @Param("example") CompanyNewsExample example);

    int updateByPrimaryKeySelective(CompanyNews record);

    int updateByPrimaryKeyWithBLOBs(CompanyNews record);

    int updateByPrimaryKey(CompanyNews record);
    
    public List<CompanyNews> selectNews(@Param("new_id") Integer new_id,@Param("company_id") Integer company_id);
}