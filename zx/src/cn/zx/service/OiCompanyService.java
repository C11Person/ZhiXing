package cn.zx.service;

import java.util.List;

import cn.zx.pojo.BootstrapTable;
import cn.zx.pojo.OiCompany;

public interface OiCompanyService {
	
	public List<OiCompany> getCompanyWithType(BootstrapTable bootstrapTable);
	
	public List<OiCompany> getCheckCompanyWithType(BootstrapTable bootstrapTable);
	
	public OiCompany getCompanyById(Integer company_id);

	public int updateExamineCompany(OiCompany company);
	
	public int removecompany(OiCompany company);
	
	public int addcompany(OiCompany company);

	public List<OiCompany> selectCompanyTypeCount();
	
	public List<OiCompany> selectCompanyProvinceCount();


}
