package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.WechatTmpl;
import cn.zx.service.impl.WechatTmplServiceImpl;

@Controller
@RequestMapping("/company/weChatTpl")
public class WechatTmplController {
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectWechatTpl.html")
	public String selectWechatTpl(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatTmpl record=new WechatTmpl();
		record.setCompany_id(companyAdmin.getCompany_id());
		
		List<WechatTmpl> listWechatTmpl=wechatTmplService.selectWechatTmpl(record);
		request.setAttribute("listWechatTmpl", listWechatTmpl);
		return "/company/info/oi_enter_weChatTpl_list";
		
	}
	/**
	 * 跳转到添加页面
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(String dataType){
		return "/company/info/oi_enter_wxTplEdit";
		
	}
	/**
	 * 编辑
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/editWeChat.html")
	public String editWeChat(WechatTmpl record,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getTmpl_id()== null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setTitle("--");
			record.setType("--");
			record.setSerial("--");
			record.setStatus(1);
			record.setCreate_time(new Date());
			wechatTmplService.insertWechatTmpl(record);
		}else{
			List<WechatTmpl> list=new ArrayList<WechatTmpl>();
			record.setUpdate_time(new Date());
			list.add(record);
			wechatTmplService.updateByPrimaryKeySelective(list);
		}
		return "/company/info/oi_enter_weChatTpl_list";
		
	}
	
	
	/**
	 * 跳转到添加页面
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String dataType,String id,
			HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatTmpl record=new WechatTmpl();
		record.setTmpl_id(Integer.parseInt(id));
		record.setCompany_id(companyAdmin.getCompany_id());
		List<WechatTmpl> list=wechatTmplService.selectWechatTmpl(record);
		request.setAttribute("WechatTmpl", list.get(0));
		return "/company/info/oi_enter_wxTplEdit";
		
	}
}
