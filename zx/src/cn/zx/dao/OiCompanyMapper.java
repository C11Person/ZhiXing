package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.BootstrapTable;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiCompanyExample;

public interface OiCompanyMapper {
    long countByExample(OiCompanyExample example);
    
    int deleteByExample(OiCompanyExample example);

    int deleteByPrimaryKey(Integer company_id);

    int insert(OiCompany record);

    int insertSelective(OiCompany record);

    List<OiCompany> selectByExample(OiCompanyExample example);

    OiCompany selectByPrimaryKey(Integer company_id);

    int updateByExampleSelective(@Param("record") OiCompany record, @Param("example") OiCompanyExample example);

    int updateByExample(@Param("record") OiCompany record, @Param("example") OiCompanyExample example);

    int updateByPrimaryKeySelective(OiCompany record);

    int updateByPrimaryKey(OiCompany record);

	List<OiCompany> selectCompanyWithType(BootstrapTable bootstrapTable);
	
	List<OiCompany> selectCompanyTypeAndCount();
	
	List<OiCompany> getCheckCompanyWithType(BootstrapTable bootstrapTable);

	List<OiCompany> getCheckCompanyWithType1(@Param("search")String search);

}