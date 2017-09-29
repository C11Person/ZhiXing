package cn.zx.dao;

import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyTaskMapper {
    long countByExample(CompanyTaskExample example);

    int deleteByExample(CompanyTaskExample example);

    int deleteByPrimaryKey(Integer task_id);

    int insert(CompanyTask record);

    int insertSelective(CompanyTask record);

    List<CompanyTask> selectByExample(CompanyTaskExample example);

    CompanyTask selectByPrimaryKey(Integer task_id);

    int updateByExampleSelective(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByExample(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByPrimaryKeySelective(CompanyTask record);

    int updateByPrimaryKey(CompanyTask record);
    
    /*List<CompanyTask> selectTaskByVaguename(@Param("vaguename") String vaguename);*/
}