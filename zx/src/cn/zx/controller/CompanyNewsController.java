package cn.zx.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.service.impl.CompanyNewsServiceImpl;

@Controller
@RequestMapping("/company/news/")
public class CompanyNewsController {
	@Autowired
	CompanyNewsServiceImpl companyNewsService;
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/slectNews.html")
	public String slectPostLevel(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyNews> list=companyNewsService.selectNews(null, companyAdmin.getCompany_id());
		request.setAttribute("listNews", list);
		return "/company/manage/oi_enter_news";
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(){
		return "/company/manage/oi_enter_enterNews_eidt";
	}
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String edit(CompanyNews record,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getNew_id() == null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			record.setCreate_time(new Date());
			record.setContent(companyAdmin.getUsername());
			companyNewsService.insertSelective(record);
		}else{
			List<CompanyNews> list=new ArrayList<CompanyNews>();
			
			record.setCreate_time(new Date());
			list.add(record);
			companyNewsService.updateByPrimaryKeySelective(list);
		}
		return "/company/manage/oi_enter_news";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyNews> list=companyNewsService.selectNews(Integer.parseInt(id), companyAdmin.getCompany_id());
		request.setAttribute("news", list.get(0));
		
		return "/company/manage/oi_enter_enterNews_eidt";
	}
}
