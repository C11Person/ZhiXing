package cn.zx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.service.impl.CompanyPropagandaServiceImpl;

@Controller
@RequestMapping("/company/propaganda")
public class CompanyPropagandaController {
	@Autowired
	CompanyPropagandaServiceImpl companyPropagandaService;
	
	/**
	 * 查询信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectPropaganda.html")
	public String selectPro(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPropaganda> listPropa=companyPropagandaService.selectPropaganda(null,companyAdmin.getCompany_id());
		request.setAttribute("listPropa", listPropa);
		return "/company/info/oi_enter_publicity";
		
	}
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insertPro(){
				return "/company/info/oi_enter_public_edit";
		
	}
	@RequestMapping("/edit.html")
	public String editPro(String dataType,CompanyPropaganda record,
			HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getP_id() == null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			companyPropagandaService.insertPropaganda(record);
		}else{
			List<CompanyPropaganda> list=new ArrayList<CompanyPropaganda>();
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(0);
			list.add(record);
			companyPropagandaService.updateByPrimaryKeySelective(list);
		}
		return "/company/info/oi_enter_publicity";
		
	}
	
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/update.html")
	public String updatePro(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPropaganda> listPropa=companyPropagandaService.selectPropaganda(Integer.parseInt(id),companyAdmin.getCompany_id());
		request.setAttribute("propa", listPropa.get(0));
		return "/company/info/oi_enter_public_edit";
		
	}
	
	
	
}
