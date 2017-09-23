package cn.zx.dao;

import cn.zx.pojo.CompanyBasic;
import cn.zx.pojo.CompanyBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyBasicMapper {
    long countByExample(CompanyBasicExample example);

    int deleteByExample(CompanyBasicExample example);

    int deleteByPrimaryKey(Integer b_id);

    int insert(CompanyBasic record);

    int insertSelective(CompanyBasic record);

    List<CompanyBasic> selectByExample(CompanyBasicExample example);

    CompanyBasic selectByPrimaryKey(Integer b_id);

    int updateByExampleSelective(@Param("record") CompanyBasic record, @Param("example") CompanyBasicExample example);

    int updateByExample(@Param("record") CompanyBasic record, @Param("example") CompanyBasicExample example);

    int updateByPrimaryKeySelective(CompanyBasic record);

    int updateByPrimaryKey(CompanyBasic record);
}