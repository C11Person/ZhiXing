package cn.zx.dao;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyAdminMapper {
    long countByExample(CompanyAdminExample example);

    int deleteByExample(CompanyAdminExample example);

    int deleteByPrimaryKey(Integer admin_id);

    int insert(CompanyAdmin record);

    int insertSelective(CompanyAdmin record);

    List<CompanyAdmin> selectByExample(CompanyAdminExample example);

    CompanyAdmin selectByPrimaryKey(Integer admin_id);

    int updateByExampleSelective(@Param("record") CompanyAdmin record, @Param("example") CompanyAdminExample example);

    int updateByExample(@Param("record") CompanyAdmin record, @Param("example") CompanyAdminExample example);

    int updateByPrimaryKeySelective(CompanyAdmin record);

    int updateByPrimaryKey(CompanyAdmin record);
}