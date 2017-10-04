package cn.zx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyBasic;
import cn.zx.service.impl.CompanyBasicServiceImpl;

@Controller
@RequestMapping("/company/Basic")
public class CompanyBasicController {
	@Autowired
	CompanyBasicServiceImpl companyBasicService;
	
	/**
	 * 查询公司基础信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectBasic.html")
	public String selectBasic(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		CompanyBasic companyBasic=companyBasicService.selectBasic(companyAdmin.getCompany_id());
		if(companyBasic != null){
			request.setAttribute("companyBasic", companyBasic);
		}else{
			request.setAttribute("companyBasic", null);
		}
		return "company/info/oi_enter_basic";
		
	}
	/**
	 * 修改公司基础信息
	 * @param companyBasic
	 * @return
	 */
	@RequestMapping("updateBasic.html")
	public String updateBasic(CompanyBasic companyBasic){
		int row=companyBasicService.updateBasicByID(companyBasic);
		if(row==1){
			return "redirect:/company/Basic/selectBasic.html";
		}else{
			return "company/info/oi_enter_basic";
		}
	}
}
