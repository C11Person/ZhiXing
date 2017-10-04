package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyStafferMapper;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.service.CompanyStafferService;

@Service("companyStafferService")
public class CompanyStafferServiceImpl implements CompanyStafferService {
	@Autowired
	CompanyStafferMapper companyStafferMapper;
	
	@Override
	public List<CompanyStaffer> selectStaffer(
			 Integer user_id,
			 Integer company_id) {
		// TODO Auto-generated method stub
		return companyStafferMapper.selectStaffer(user_id, company_id);
	}

	@Override
	public int insertSelective(CompanyStaffer record) {
		// TODO Auto-generated method stub
		return companyStafferMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyStaffer> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyStafferMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return row;
	}
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
