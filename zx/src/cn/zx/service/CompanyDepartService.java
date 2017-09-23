package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;

public interface CompanyDepartService {
	/**
	 * 根据根据公司ID查询公司部门
	 */
	List<CompanyDepart> selectDepartByCompanyId(CompanyDepartExample companyDepartExample);
}