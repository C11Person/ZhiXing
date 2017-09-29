/**
 * 
 */
package cn.zx.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyStafferMapper;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.service.CompanyStafferService;

/**
 * @author AYao
 *
 */
@Service("companyStafferService")
public class CompanyStafferServiceImpl implements CompanyStafferService {
	@Autowired
	private CompanyStafferMapper companyStafferMapper;
	
	@Override
	public List<CompanyStaffer> selectStaffByCompanyIdAndDepartId(CompanyStafferExample companyStafferExample) {
		return companyStafferMapper.selectByExample(companyStafferExample);
	}

	@Override
	public boolean staffUpdateEmailOrTelphone(CompanyStaffer companyStaffer) {
		return companyStafferMapper.updateByPrimaryKeySelective(companyStaffer)==1;
	}

	@Override
	public CompanyStaffer selectStafferByUserId(Integer user_id) {
		return companyStafferMapper.selectByPrimaryKey(user_id);
	}

	@Override
	public List<CompanyStaffer> staffLogin(CompanyStafferExample companyStafferExample) {
		return companyStafferMapper.selectByExample(companyStafferExample);
	}

	@Override
	public CompanyStaffer selectStaffByDepartAndPost(Integer user_id, Integer company_id) {
		return companyStafferMapper.selectStaffByDepartAndPost(user_id, company_id);
	}

	@Override
	public List<CompanyStaffer> selectStaffByCompanyId(Integer company_id) {
		return companyStafferMapper.selectStaffByCompanyId(company_id);
	}







	

}
