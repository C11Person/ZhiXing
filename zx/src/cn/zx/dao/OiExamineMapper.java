package cn.zx.dao;

import cn.zx.pojo.OiExamine;
import cn.zx.pojo.OiExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OiExamineMapper {
    long countByExample(OiExamineExample example);

    int deleteByExample(OiExamineExample example);

    int deleteByPrimaryKey(Integer ex_id);

    int insert(OiExamine record);

    int insertSelective(OiExamine record);

    List<OiExamine> selectByExample(OiExamineExample example);

    OiExamine selectByPrimaryKey(Integer ex_id);

    int updateByExampleSelective(@Param("record") OiExamine record, @Param("example") OiExamineExample example);

    int updateByExample(@Param("record") OiExamine record, @Param("example") OiExamineExample example);

    int updateByPrimaryKeySelective(OiExamine record);

    int updateByPrimaryKey(OiExamine record);
}