package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyNewsMapper;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.service.CompanyNewsService;

@Service("companyNewsService")
public class CompanyNewsServiceImpl implements CompanyNewsService{
	@Autowired
	CompanyNewsMapper companyNewsMapper;

	@Override
	public List<CompanyNews> selectNews(Integer new_id, Integer company_id) {
		// TODO Auto-generated method stub
		return companyNewsMapper.selectNews(new_id, company_id);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyNews> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyNewsMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
			
		}
		return row;
	}

	@Override
	public int insertSelective(CompanyNews record) {
		// TODO Auto-generated method stub
		return companyNewsMapper.insertSelective(record);
	}
	
	@Override
	public List<CompanyNews> selectAllCompanyNewsByCompanyId(CompanyNewsExample companyNewsExample) {
		return companyNewsMapper.selectByExample(companyNewsExample);
	}
}
