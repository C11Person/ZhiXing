package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyRole;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.WechatTmpl;
import cn.zx.service.impl.CompanyNewsServiceImpl;
import cn.zx.service.impl.CompanyPostLevelServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.CompanyPropagandaServiceImpl;
import cn.zx.service.impl.CompanyRoleServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.WechatTmplServiceImpl;

@Controller
@RequestMapping("/company/deleteInfo")
public class DeleteInfoController {
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	@Autowired
	CompanyPropagandaServiceImpl companyPropagandaService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	CompanyPostLevelServiceImpl companyPostLevelService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	CompanyNewsServiceImpl companyNewsService;
	@Autowired
	CompanyRoleServiceImpl companyRoleService;
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public Object deleteCompany(String dataType,String id,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(dataType.equals("oi_enter_weList")){
			WechatTmpl record=new WechatTmpl();
			List<WechatTmpl> list=new ArrayList<WechatTmpl>();
			record.setTmpl_id(Integer.parseInt(id));
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(0);
			record.setUpdate_time(new Date());
			list.add(record);
			wechatTmplService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_publicity")){
			CompanyPropaganda record=new CompanyPropaganda();
			List<CompanyPropaganda> list=new ArrayList<CompanyPropaganda>();
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setP_id(Integer.parseInt(id));
			record.setStatus(0);
			list.add(record);
			companyPropagandaService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_grade")){
			List<CompanyPost>  list=new ArrayList<CompanyPost>();
			CompanyPost record =new CompanyPost();
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setIsdelete(0);
			record.setUpdate_time(new Date());
			record.setPost_id(Integer.parseInt(id));
			list.add(record);
			companyPostService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_rank")){
			List<CompanyPostLevel> list=new ArrayList<CompanyPostLevel>();
			CompanyPostLevel record = new CompanyPostLevel();
			record.setPost_le_id(Integer.parseInt(id));
			record.setUpdate_time(new Date());
			record.setIsdelete(0);
			list.add(record);
			companyPostLevelService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_staffMng")){
			
			CompanyStaffer record=new CompanyStaffer();
			List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
			record.setUser_id(Integer.parseInt(id));
			record.setStatus(0);
			list.add(record);
			companyStafferService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_news_01")){
			CompanyNews record=new CompanyNews();
			List<CompanyNews> list=new ArrayList<CompanyNews>();
			record.setNew_id(Integer.parseInt(id));
			record.setStatus(0);
			list.add(record);
			companyNewsService.updateByPrimaryKeySelective(list);
		}else if(dataType.equals("oi_enter_character_table")){
			CompanyRole record=new CompanyRole();
			List<CompanyRole> list=new ArrayList<CompanyRole>();
			record.setUser_id(Integer.parseInt(id));
			record.setStatus(0);
			list.add(record);
			companyRoleService.updateByPrimaryKeySelective(list);
		}
		
		
		
		return JSONArray.toJSON("成功");
		
	}
}
