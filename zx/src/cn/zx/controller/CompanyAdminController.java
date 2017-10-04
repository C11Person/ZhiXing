package cn.zx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;
import cn.zx.tool.SmsTool;
import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.SmsMessage;
import cn.zx.service.impl.CompanyAdminServiceImpl;
import cn.zx.tool.MD5Tool;

@Controller
@RequestMapping("/company/admin")
public class CompanyAdminController {
	@Autowired
	CompanyAdminServiceImpl companyAdminService;
	
	/*@RequestMapping(value="/index.html")
	public String index(){
		return "company/index";
	}*/
	
	/**
	 * 企业管理员登录
	 * @param phone
	 * @param password
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/dologin.html")
	public String dologin(@RequestParam(required=false) String phone,
			@RequestParam(required=false) String password,
			HttpServletRequest request,
			HttpSession session){
		
		
		
		
		CompanyAdmin companyAdmin=new CompanyAdmin();
		MD5Tool md5=new MD5Tool();
		companyAdmin.setPhone(phone);
		
		List<CompanyAdmin> list=companyAdminService.selectAdminByName(null,phone);
		for (int i = 0; i <list.size(); i++) {
			if(list.get(i).getPhone()== phone){
				if(password !=null && !password.equals("")){
					
					companyAdmin.setPassword(md5.MD5(password+list.get(i).getRandom()));
				}
				
			}
			
		}
		CompanyAdmin companyAdminGet=companyAdminService.login(companyAdmin);
		if(companyAdminGet!=null){
			ObtainIp obtainIp=new ObtainIp();
			companyAdminGet.setCreate_ip(obtainIp.getIpAddr(request));
			companyAdminGet.setLast_time(new Date());
			int row=companyAdminService.updateByPrimaryKeySelective(companyAdminGet);
			System.out.println(row);
			session.setAttribute("companyAdmin", companyAdminGet);
			return "company/index";
		}else{
			return "login";		
		}		
		
		
		
	}
	/**
	 * 发送验证码
	 * @param companyAdmin
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/sendSms.do")
	@ResponseBody
	public Object SendSms(CompanyAdmin companyAdmin,String code){
		//生成6位随机数
				int random=(int)((Math.random()*9+1)*100000);
				List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(companyAdmin.getUsername(),null);
				if(listAdmin.size()!=0){
					SmsMessage smsMess=new SmsMessage();
					smsMess.setSmtext(String.valueOf(random));//发送内容
					smsMess.setSmsmob(listAdmin.get(0).getPhone());//接收电话号码
					smsMess.setKey("");//密钥
					smsMess.setUid("");//发送人

					SmsTool smsTool=new SmsTool();
					String result=smsTool.sendSMS(smsMess);//发送短信
					if(result.length()>0){
						if(code.equals(smsMess.getSmtext())){
							return JSONArray.toJSON(1);
						}else{
							//-2表示验证码不匹配
							return JSONArray.toJSON(-2);
						}
					}else{
						//-3表示信息发送失败
						return JSONArray.toJSON(-3);
					}
				}else{
					//-1表示暂无此人
					return JSONArray.toJSON(-1);
				}
	}
	/**
	 * 跳转到忘记密码页
	 * @return
	 */
	@RequestMapping(value="/updatePassword.html")
	public String updatePassword(){
		return "";
	}
	/**
	 * 修改密码及忘记密码
	 * @param companyAdmin
	 * @return
	 */
	@RequestMapping(value="/updatePassword.do")
	@ResponseBody
	public Object updatePassword(CompanyAdmin companyAdmin){
		MD5Tool md5=new MD5Tool();
		
		companyAdmin.setPassword(md5.MD5(companyAdmin.getPassword()));
		
		int row=companyAdminService.updatePasswordByUsername(companyAdmin);
		if(row==1){
			return JSONArray.toJSON(row);
		}else{
			//0表示无返回结果
			return JSONArray.toJSON(0);
		}
	}
	
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	
	@RequestMapping(value="/selectAdmin.html")
	public String selectAdmin(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		companyAdmin.setUsername("");
		companyAdmin.setPhone("");
		companyAdmin.setPassword("");
		
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdmin(companyAdmin);
		request.setAttribute("companyAdmins", listAdmin);
		return "/company/user/oi_enter_manager";
	}
	/**
	 * 查询所有管理员
	 * @return
	 */
	@RequestMapping(value="/selectAdmin.do")
	@ResponseBody
	public Msg selectAdmin(String value,
			String pageSize,
			@RequestParam(value="pn",defaultValue="1") Integer pn){
		CompanyAdmin companyAdmin=new CompanyAdmin();
		companyAdmin.setAdmin_id(Integer.parseInt(value));
		PageHelper.startPage(pn, Integer.parseInt(pageSize));
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdmin(companyAdmin);
		PageInfo<CompanyAdmin> page=new PageInfo<>(listAdmin, 3);
		return Msg.success().add("pageinfo", page);
	}
	
	/**
	 * 根据ID查询企业管理员
	 * @param admin_id
	 * @return
	 */
	@RequestMapping(value="/selectAdminByID.do")
	@ResponseBody
	public Object selectAdminByID(int admin_id){
		CompanyAdmin companyAdmin=companyAdminService.selectByPrimaryKey(admin_id);
		if(companyAdmin !=null){
			return JSONArray.toJSON(companyAdmin);
		}else{
			return "error";
		}
	}
	/**
	 * 根据ID修改企业管理员
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/UpdateAdminByID.do")
	@ResponseBody
	public Object UpdateAdminByID(CompanyAdmin record){
		//CompanyAdmin record=new CompanyAdmin();
		int row=companyAdminService.updateByPrimaryKeySelective(record);
		if(row ==1){
			return JSONArray.toJSON(row);
		}else{
			return "error";
		}
	}
	/**
	 * 跳转到注册账号
	 * @return
	 */
	@RequestMapping(value="/insert.html")
	public String register(){
		return "company/user/oi_enter_manager";
	}
	/**
	 * 注册及添加
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/edit.html")
	public String InsertAdmin(CompanyAdmin record,HttpServletRequest request){
		int random=(int)((Math.random()*9+1)*100000);
		MD5Tool md5=new MD5Tool();
		if(record.getAdmin_id() == null){
			List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(record.getUsername(),record.getPhone());
			if(listAdmin.size()==0){
				return "/company/user/oi_enter_manager";
			}else{
				record.setRole(1);
				ObtainIp obtainIp=new ObtainIp();
				record.setCreate_ip(obtainIp.getIpAddr(request));
				record.setCreate_time(new Date());
				record.setRandom(String.valueOf(random));
				record.setPassword(md5.MD5(record.getPassword()+random));
				
				companyAdminService.selectAdmin(record);
				int row=companyAdminService.insert(record);
			}
		}else{
			List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(record.getUsername(),record.getPhone());
			if(listAdmin.size()==0){
				return "/company/user/oi_enter_manager";
			}else{
				record.setRole(1);
				ObtainIp obtainIp=new ObtainIp();
				record.setCreate_ip(obtainIp.getIpAddr(request));
				record.setPassword(md5.MD5(record.getPassword()+listAdmin.get(0).getRandom()));
				
				companyAdminService.selectAdmin(record);
				int row=companyAdminService.updateByPrimaryKeySelective(record);
				}
		}
		return "/company/user/oi_enter_manager";
	}
	
	/**
	 * 跳转到注册账号
	 * @return
	 */
	@RequestMapping(value="/update.html")
	public String update(String id,HttpServletRequest request){
		
		CompanyAdmin companyAdmin=companyAdminService.selectByPrimaryKey(Integer.parseInt(id));
		request.setAttribute("companyAdmin", companyAdmin);
		return "company/user/oi_enter_manager";
	}
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginOut.html")
	public String loginOut(HttpSession session){
		session.invalidate();
		return "";
		
	}
}
