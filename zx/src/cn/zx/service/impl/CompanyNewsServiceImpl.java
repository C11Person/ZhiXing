/**
 * 
 */
package cn.zx.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyNewsMapper;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.service.CompanyNewsService;

/**
 * @author AYao
 *
 */
@Service("companyNewsService")
public class CompanyNewsServiceImpl implements CompanyNewsService {
	@Autowired
	private CompanyNewsMapper companyNewsMapper;
	
	@Override
	public List<CompanyNews> selectAllCompanyNewsByCompanyId(CompanyNewsExample companyNewsExample) {
		return companyNewsMapper.selectByExample(companyNewsExample);
	}
	
}
