package cn.zx.dao;

import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPostLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPostLevelMapper {
    long countByExample(CompanyPostLevelExample example);

    int deleteByExample(CompanyPostLevelExample example);

    int deleteByPrimaryKey(Integer post_le_id);

    int insert(CompanyPostLevel record);

    int insertSelective(CompanyPostLevel record);

    List<CompanyPostLevel> selectByExample(CompanyPostLevelExample example);

    CompanyPostLevel selectByPrimaryKey(Integer post_le_id);

    int updateByExampleSelective(@Param("record") CompanyPostLevel record, @Param("example") CompanyPostLevelExample example);

    int updateByExample(@Param("record") CompanyPostLevel record, @Param("example") CompanyPostLevelExample example);

    int updateByPrimaryKeySelective(CompanyPostLevel record);

    int updateByPrimaryKey(CompanyPostLevel record);
}