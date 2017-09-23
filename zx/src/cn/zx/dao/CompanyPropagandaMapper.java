package cn.zx.dao;

import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyPropagandaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPropagandaMapper {
    long countByExample(CompanyPropagandaExample example);

    int deleteByExample(CompanyPropagandaExample example);

    int deleteByPrimaryKey(Integer p_id);

    int insert(CompanyPropaganda record);

    int insertSelective(CompanyPropaganda record);

    List<CompanyPropaganda> selectByExample(CompanyPropagandaExample example);

    CompanyPropaganda selectByPrimaryKey(Integer p_id);

    int updateByExampleSelective(@Param("record") CompanyPropaganda record, @Param("example") CompanyPropagandaExample example);

    int updateByExample(@Param("record") CompanyPropaganda record, @Param("example") CompanyPropagandaExample example);

    int updateByPrimaryKeySelective(CompanyPropaganda record);

    int updateByPrimaryKey(CompanyPropaganda record);
}