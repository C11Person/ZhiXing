package cn.zx.dao;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyStafferMapper {
    long countByExample(CompanyStafferExample example);

    int deleteByExample(CompanyStafferExample example);

    int deleteByPrimaryKey(Integer user_id);

    int insert(CompanyStaffer record);

    int insertSelective(CompanyStaffer record);

    List<CompanyStaffer> selectByExample(CompanyStafferExample example);

    CompanyStaffer selectByPrimaryKey(Integer user_id);

    int updateByExampleSelective(@Param("record") CompanyStaffer record, @Param("example") CompanyStafferExample example);

    int updateByExample(@Param("record") CompanyStaffer record, @Param("example") CompanyStafferExample example);

    int updateByPrimaryKeySelective(CompanyStaffer record);

    int updateByPrimaryKey(CompanyStaffer record);
}