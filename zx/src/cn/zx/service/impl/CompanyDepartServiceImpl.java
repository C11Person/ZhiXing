/**
 * 
 */
package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyDepartMapper;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.service.CompanyDepartService;

/**
 * @author AYao
 *
 */
@Service("companyDepartService")
public class CompanyDepartServiceImpl implements CompanyDepartService {
	@Autowired
	private CompanyDepartMapper companyDepartMapper; 
	
	@Override
	public List<CompanyDepart> selectDepartByCompanyId(CompanyDepartExample companyDepartExample) {
		return companyDepartMapper.selectByExample(companyDepartExample);
	}
	
}
