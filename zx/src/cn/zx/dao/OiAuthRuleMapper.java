package cn.zx.dao;

import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OiAuthRuleMapper {
    long countByExample(OiAuthRuleExample example);

    int deleteByExample(OiAuthRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OiAuthRule record);

    int insertSelective(OiAuthRule record);

    List<OiAuthRule> selectByExampleWithBLOBs(OiAuthRuleExample example);

    List<OiAuthRule> selectByExample(OiAuthRuleExample example);

    OiAuthRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OiAuthRule record, @Param("example") OiAuthRuleExample example);

    int updateByExampleWithBLOBs(@Param("record") OiAuthRule record, @Param("example") OiAuthRuleExample example);

    int updateByExample(@Param("record") OiAuthRule record, @Param("example") OiAuthRuleExample example);

    int updateByPrimaryKeySelective(OiAuthRule record);

    int updateByPrimaryKeyWithBLOBs(OiAuthRule record);

    int updateByPrimaryKey(OiAuthRule record);
}