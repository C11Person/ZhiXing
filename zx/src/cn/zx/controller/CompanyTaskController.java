package cn.zx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyTask;
import cn.zx.service.impl.CompanyTaskServiceImpl;

@Controller
@RequestMapping("/company/task")
public class CompanyTaskController {
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	
	
	@RequestMapping("/selectTask.html")
	public String selectTask(HttpSession session,
			HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyTask> list=companyTaskService.selectTask(companyAdmin.getCompany_id());
		request.setAttribute("listTask", list);
		
		return "/company/manage/oi_enter_taskCenter";
	}
}
