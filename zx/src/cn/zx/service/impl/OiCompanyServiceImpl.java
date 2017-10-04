package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiCompanyMapper;
import cn.zx.pojo.BootstrapTable;
import cn.zx.pojo.OiCompany;
import cn.zx.service.OiCompanyService;
@Service("OiCompanyService")
public class OiCompanyServiceimpl implements OiCompanyService {
@Autowired
OiCompanyMapper oiCompanyMapper;

	@Override
	public int updateExamineCompany(OiCompany company){
		// TODO Auto-generated method stub
		return oiCompanyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public OiCompany getCompanyById(Integer company_id) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectByPrimaryKey(company_id);
	}
	@Override
	public int removecompany(OiCompany company) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public int addcompany(OiCompany company) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.insertSelective(company);
	}
	@Override
	public List<OiCompany> selectCompanyTypeCount() {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectCompanyTypeAndCount();
	}
	@Override
	public List<OiCompany> selectCompanyProvinceCount() {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectCompanyTypeAndCount();
	}
	@Override
	public List<OiCompany> getCompanyWithType(BootstrapTable bootstrapTable) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectCompanyWithType(bootstrapTable);
	}
	@Override
	public List<OiCompany> getCheckCompanyWithType(BootstrapTable bootstrapTable) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.getCheckCompanyWithType(bootstrapTable);
	}
}
