package cn.zx.dao;

import cn.zx.pojo.CompanyMessage;
import cn.zx.pojo.CompanyMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyMessageMapper {
    long countByExample(CompanyMessageExample example);

    int deleteByExample(CompanyMessageExample example);

    int deleteByPrimaryKey(Integer m_id);

    int insert(CompanyMessage record);

    int insertSelective(CompanyMessage record);

    List<CompanyMessage> selectByExample(CompanyMessageExample example);

    CompanyMessage selectByPrimaryKey(Integer m_id);

    int updateByExampleSelective(@Param("record") CompanyMessage record, @Param("example") CompanyMessageExample example);

    int updateByExample(@Param("record") CompanyMessage record, @Param("example") CompanyMessageExample example);

    int updateByPrimaryKeySelective(CompanyMessage record);

    int updateByPrimaryKey(CompanyMessage record);
}