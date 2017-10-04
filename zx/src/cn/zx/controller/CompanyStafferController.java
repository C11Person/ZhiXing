package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.service.impl.CompanyStafferServiceImpl;

@Controller
@RequestMapping("/company/staffer")
public class CompanyStafferController {
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/slectStaffer.html")
	public String slectStaffer(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyStaffer> list= companyStafferService.selectStaffer(null, companyAdmin.getCompany_id());
		request.setAttribute("listStaffer", list);
		return "/company/manage/oi_enter_staffMng";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String edit(CompanyStaffer record,HttpServletRequest request,
			HttpSession session){
			CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
			List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
			
			list.add(record);
			companyStafferService.updateByPrimaryKeySelective(list);
		return "/company/manage/oi_enter_staffMng";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyStaffer> list=companyStafferService.selectStaffer(Integer.parseInt(id), companyAdmin.getCompany_id());
		request.setAttribute("staffer", list.get(0));
		return "/company/manage/oi_enter_staff_edit";
	}
	
}
