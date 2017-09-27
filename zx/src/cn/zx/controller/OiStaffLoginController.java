package cn.zx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.service.CompanyStafferService;

@RequestMapping("/staffLogin")
@Controller
public class OiStaffLoginController {
	@Autowired
	CompanyStafferService companyStafferService;
	
	//登陆
	@RequestMapping(value="/login.json")
	@ResponseBody
	public boolean staffLogin(String sf_username,String sf_password,HttpSession session){
		System.out.println("=================================="+sf_username);
		System.out.println("=================================="+sf_password);
		
		cn.zx.pojo.CompanyStafferExample example  = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria criteria=example.createCriteria();
		criteria.andPhoneEqualTo(sf_username);
		criteria.andSf_passwordEqualTo(sf_password);
		
		List<CompanyStaffer> companyStaffers = companyStafferService.staffLogin(example);
		System.out.println(companyStaffers.get(0).getEmail()+"=======================");
		if(companyStaffers.size()!=0){
			CompanyStaffer companyStaffer= companyStaffers.get(0);
			session.setAttribute("companyStaffer", companyStaffer);
			return true;
		}else{
			return false;
		}
		
	}
	
	//注销
	@RequestMapping(value = "/oi_staff_login.html")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "staff/oi_staff_login";
	}
}
