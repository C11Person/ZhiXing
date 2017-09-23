package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;

public interface CompanyNewsService {
   /**
    * 企业公告信息
    */
	List<CompanyNews> selectAllCompanyNewsByCompanyId(CompanyNewsExample companyNewsExample);
}