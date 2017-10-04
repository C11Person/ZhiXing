package cn.zx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.TreeModel;
import cn.zx.service.impl.CompanyDepartServiceImpl;

@Controller
@RequestMapping("/company/dept")
public class CompanyDepartController {
	@Autowired
	CompanyDepartServiceImpl companyDepartService;
	
	public static final String ROOT="0";//顶级部门
	
	@RequestMapping("/selectDept.html")
	public String slectDept(){
		return "/company/manage/oi_enter_branch_mng";
	}
	/**
	 * 查询部门表
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectDept.do")
	@ResponseBody
	public Object selectDept(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		String id=ROOT;
		TreeModel tm = companyDepartService.selectTree(id, companyAdmin.getCompany_id(), true);
		return JSONArray.toJSON(tm.getChildren());
		
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insertDept.html")
	public String insertDept(HttpSession session,
			HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyDepart> listName=companyDepartService.selectDeptName(null,companyAdmin.getCompany_id());
		request.setAttribute("listName", listName);
		return "/company/manage/oi_enter_branch_edit";
		
	}
	@RequestMapping("/selectName.do")
	@ResponseBody
	public Object selectName(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyDepart> list=companyDepartService.selectDeptName(null,companyAdmin.getCompany_id());
		System.out.println(JSONArray.toJSON(list));
		return JSONArray.toJSON(list);
		
	}
	
	@RequestMapping("/edit.html")
	public String editDept(CompanyDepart record,HttpSession session){
		System.out.println(record.getCom_id());
		if(record.getDept_id() == null){
			CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			record.setIsdelete(1);
			record.setLevel(1);
			
			companyDepartService.insertSelective(record);
		}else{
			List<CompanyDepart> list =new ArrayList<CompanyDepart>();
			/*CompanyDepart record=new CompanyDepart();
			record.setStatus(0);
			record.setIsdelete(0);*/
			list.add(record);
			companyDepartService.updateByPrimaryKeySelective(list);
			
		}
		
		return "/company/manage/oi_enter_branch_mng";
	}
	
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyDepart> listName=companyDepartService.selectDeptName(null,companyAdmin.getCompany_id());
		request.setAttribute("listName", listName);
		
		List<CompanyDepart> list=companyDepartService.selectDeptName(Integer.parseInt(id),null);
		request.setAttribute("depart", list.get(0));
		return "/company/manage/oi_enter_branch_edit";
	}
	/**
	 * 删除
	 * @param session
	 * @return
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public Object delete(String id,HttpSession session){
		List<CompanyDepart> list =new ArrayList<CompanyDepart>();
		CompanyDepart record=new CompanyDepart();
		record.setDept_id(Integer.parseInt(id));
		record.setStatus(0);
		record.setIsdelete(0);
		list.add(record);
		int row=companyDepartService.updateByPrimaryKeySelective(list);
		return JSONArray.toJSON(row);
		
	}
	
}
