package cn.zx.dao;

import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPostMapper {
    long countByExample(CompanyPostExample example);

    int deleteByExample(CompanyPostExample example);

    int deleteByPrimaryKey(Integer post_id);

    int insert(CompanyPost record);

    int insertSelective(CompanyPost record);

    List<CompanyPost> selectByExample(CompanyPostExample example);

    CompanyPost selectByPrimaryKey(Integer post_id);

    int updateByExampleSelective(@Param("record") CompanyPost record, @Param("example") CompanyPostExample example);

    int updateByExample(@Param("record") CompanyPost record, @Param("example") CompanyPostExample example);

    int updateByPrimaryKeySelective(CompanyPost record);

    int updateByPrimaryKey(CompanyPost record);
}