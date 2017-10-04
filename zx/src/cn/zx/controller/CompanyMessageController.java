package cn.zx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyMessage;
import cn.zx.service.impl.CompanyMessageServiceImpl;

@Controller
@RequestMapping("/company/message")
public class CompanyMessageController {
	@Autowired
	CompanyMessageServiceImpl companyMessageService;
	
	@RequestMapping(value="/selectMessage.html")
	public String selectMessage(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		CompanyMessage companyMessage=new CompanyMessage();
		companyMessage.setM_id(companyAdmin.getCompany_id());
		
		List<CompanyMessage> listMessage=companyMessageService.selectMessage(companyMessage);
		if(listMessage.size()>0){
			request.setAttribute("Message", listMessage.get(0));
		}else{
			request.setAttribute("Message", null);
		}
		
		return "/company/info/oi_enter_infolist";
	}
	/**
	 * 修改企业信息根据ID
	 * @param companyMessage
	 * @return
	 */
	@RequestMapping(value="/updateMessage.html")
	public String updateMessage(CompanyMessage companyMessage){
		int row=companyMessageService.updateMessageByID(companyMessage);
		if(row==1){
			return "redirect:/company/message/selectMessage.html";
		}else{
			return "/company/info/oi_enter_infolist";
		}
		
		
	}
	
}
