package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;

public interface CompanyStafferService {
    /**
     * 根据公司ID和部门ID查询员工
     */
	List<CompanyStaffer> selectStaffByCompanyIdAndDepartId(CompanyStafferExample companyStafferExample);
	
	/**
	 * 职员修改邮箱地址、手机号
	 */
	boolean staffUpdateEmailOrTelphone(CompanyStaffer companyStaffer);
}