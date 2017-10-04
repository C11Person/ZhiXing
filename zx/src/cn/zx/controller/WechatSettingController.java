package cn.zx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.WechatSetting;
import cn.zx.service.impl.WechatSettingServiceImpl;

@Controller
@RequestMapping("/company/weChatSet")
public class WechatSettingController {
	@Autowired
	WechatSettingServiceImpl wechatSettingService;
	
	/**
	 * 查询微信基础设置
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectWechat.html")
	public String selectWechart(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatSetting wechatSetting=wechatSettingService.selectWechat(companyAdmin.getCompany_id());
		request.setAttribute("wechatSetting", wechatSetting);
		return "/company/info/oi_enter_weChat";
	}
	/**
	 * 修改微信基础设置信息
	 * @param wechatSetting
	 * @return
	 */
	@RequestMapping("/updateWechat.html")
	public String updateWechat(WechatSetting wechatSetting){
		int row=wechatSettingService.updateWechatByID(wechatSetting);
		if(row==1){
			return "redirect:/company/weChatSet/selectWechat.html";
		}else{
			return "/company/info/oi_enter_weChat";
		}
		
		
	}
}
