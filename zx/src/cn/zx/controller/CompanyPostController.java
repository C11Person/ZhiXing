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
import cn.zx.pojo.CompanyPost;
import cn.zx.service.impl.CompanyPostServiceImpl;

@Controller
@RequestMapping("company/post")
public class CompanyPostController {
	@Autowired
	CompanyPostServiceImpl companyPostService;
	
	/**
	 * 查询信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectPost.html")
	public String selectPost(HttpServletRequest request,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost>  list=companyPostService.selectPost(null,companyAdmin.getCompany_id());
		request.setAttribute("list", list);
		return "company/manage/oi_enter_grade";
		
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(){
		return "company/manage/oi_enter_grade_edit";
		
	}
	
	/**
	 * 编辑
	 * @param record
	 * @return
	 */
	@RequestMapping("/editPost.html")
	public String editPost(CompanyPost record,HttpSession session){
		if(record.getPost_id()==null){
			CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
			record.setCreate_time(new Date());
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setIsdelete(1);
			companyPostService.insertPost(record);
		}else{
			List<CompanyPost> list=new ArrayList<CompanyPost>();
			record.setUpdate_time(new Date());
			list.add(record);
			companyPostService.updateByPrimaryKeySelective(list);
		}
		
		
		return "company/manage/oi_enter_grade";
		
	}
	
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,
			HttpServletRequest request,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost>  list=companyPostService.selectPost(Integer.parseInt(id),companyAdmin.getCompany_id());
		request.setAttribute("post", list.get(0));
		return "company/manage/oi_enter_grade_edit";
		
	}
	
}
