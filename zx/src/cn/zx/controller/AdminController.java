package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zx.dao.OiTypeMapper;
import cn.zx.pojo.OiAdmin;
import cn.zx.pojo.OiAdminExample;
import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import cn.zx.pojo.OiAuthRuleExample.Criteria;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiCompanyExample;
import cn.zx.pojo.OiDistrict;
import cn.zx.pojo.OiDistrictExample;
import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiRoleExample;
import cn.zx.pojo.OiSite;
import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;
import cn.zx.service.OiAdminService;
import cn.zx.service.OiAuthRuleService;
import cn.zx.service.OiCompanyService;
import cn.zx.service.OiDistrictService;
import cn.zx.service.OiRoleService;
import cn.zx.service.OiSiteService;
import cn.zx.service.OiTypeService;
import cn.zx.pojo.BootstrapTable;
import cn.zx.tool.GetIp;
import cn.zx.tool.Msg;


@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	OiSiteService oiSiteService;
	@Autowired
	OiDistrictService oiDistrictService;
	@Autowired
	OiAuthRuleService oiAuthRuleService;
	@Autowired
	OiTypeService oiTypeService;
	@Autowired
	OiCompanyService oiCompanyService;
	@Autowired
	OiRoleService oiRoleService;
	@Autowired
	OiAdminService oiAdminService;
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value="/oi_admin_index.html")
	public String indexPage(){
		return "/admin/index_v3";
	}
	/**
	 * 后台设置
	 * @return
	 */
	@RequestMapping(value="/oi_admin_siteSet.html")
	public String siteSetPage(){
		return "/admin/oi_admin_siteSet";
	}
	/**
	 * 企业类型
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_type.html")
	public String enterTypePage(){
		return "/admin/oi_admin_enter_type";
	}
	/**
	 * 企业地区
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_area.html")
	public String enterAreaPage(){
		return "/admin/oi_admin_enter_area";
	}
	/**
	 * 企业审核
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_list.html")
	public String enterListPage(){
		return "/admin/oi_admin_enter_list";
	}
	/**
	 * 系统管理员
	 * @return
	 */
	@RequestMapping(value="/oi_admin_manager.html")
	public String adminManagerPage(){
		return "/admin/oi_admin_manager";
	}
	/**
	 * 系统角色
	 * @return
	 */
	@RequestMapping(value="/oi_admin_character.html")
	public String adminCharacterPage(){
		return "/admin/oi_admin_character";
	}
	/**
	 * 全国数据
	 * @return
	 */
	@RequestMapping(value="/oi_admin_data_center.html")
	public String adminCenterPage(){
		return "/admin/oi_admin_data_center";
	}
	/**
	 * 弹出公司修改
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_edite.html")
	public String adminAddConpanyPage(@RequestParam(value="companyId",required=false) Integer companyId,HttpServletRequest request){
		request.setAttribute("company", companyId);
		return "/admin/oi_admin_enter_edite";
	}
	/**
	 * 审核页面
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_check.html")
	public String adminCheckPage(){
		return "/admin/oi_admin_enter_check";
	}
	/**
	 * 添加类型
	 * @return
	 */
	@RequestMapping(value="/oi_admin_en_typeTree_edit.html")
	public String adminAddTypetPage(@RequestParam(value="type") String type,@RequestParam(value="type_id",required=false,defaultValue="1") Integer type_id,HttpServletRequest request){
		System.out.println(type);
		if(type.equals("edit")){
			OiType oitype = oiTypeService.getTypeById(type_id);
			request.setAttribute("type", oitype);
			request.setAttribute("type_id", oitype.getPid());
		}else{
			request.setAttribute("type_id", type_id);
		}
		return "/admin/oi_admin_en_typeTree_edit";
	}
	/**
	 * 添加地区
	 * @return
	 */
	@RequestMapping(value="/oi_admin_en_districtTree_edit.html")
	public String adminAddDistrictPage(@RequestParam(value="type") String type,@RequestParam(value="district_id",required=false,defaultValue="1") Integer district_id,HttpServletRequest request){
		System.out.println(type);
		if(type.equals("edit")){
			OiDistrict oiDistrict = oiDistrictService.getDistrictById(district_id);
			request.setAttribute("oidistrict", oiDistrict);
			request.setAttribute("district_id", oiDistrict.getPid());
			System.out.println(oiDistrict);
		}else{
			request.setAttribute("district_id", district_id);
		}
		return "/admin/oi_admin_en_districtTree_edit";
	}
	
	/**
	 * 角色修改
	 * @param adminId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_mng_edite.html")
	public String updateRolePage(@RequestParam(value="adminId",required=false)Integer adminId,
			HttpServletRequest request){
		System.out.println(adminId);
			request.setAttribute("adminId", adminId);
		return "/admin/oi_admin_mng_edite";
	}
	/**
	 * 管理员修改
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_chara_edite.html")
	public String updateAdminPage(@RequestParam(value="roleId",required=false)Integer roleId,
			HttpServletRequest request){
		System.out.println(roleId);
			request.setAttribute("roleId", roleId);
		return "/admin/oi_admin_chara_edite";
	}
	/**
	 * 角色新增
	 * @param adminId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_chara_add.html")
	public String addAdminPage(){
		return "/admin/oi_admin_chara_add";
	}
	
	
	
	/**
	 * 修改准备
	 * @param roleid
	 * @return
	 */
	@RequestMapping(value="/getroleandrule/{roleid}",method=RequestMethod.POST)
	@ResponseBody
	public Object getroleandrule(@PathVariable("roleid")Integer roleid){
		System.out.println(roleid);
		OiRole role = oiRoleService.getOiRoleByid(roleid);
		List<Integer>  roles=new ArrayList<>();
		String[] str_ids = role.getRules().split(",");
		//组装id集合
		for ( String string: str_ids) {
			roles.add(Integer.parseInt(string));
		}
		role.setRules(null);
		role.setRule(roles);
		List<Object> list=new ArrayList<Object>();
		OiAuthRule recursiveTree = AuthRuleTree(1);
		list.add(role);
		list.add(recursiveTree);
		return JSONArray.toJSONString(list);
		
	}
	
	/**
	 * 获取分类
	 * @param pro_id
	 * @return
	 */
	@RequestMapping(value="/findtype",method=RequestMethod.GET)
	@ResponseBody
	public Msg gettype(){
		List<OiType> types = oiTypeService.getType(null);
		return Msg.success().add("Types", types);
	}
	/**
	 * 审核公司
	 */
	@RequestMapping(value="/checkcompany.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkcompany(@RequestParam("company_id") Integer company_id,@RequestParam("type") String type){	
		//System.out.println(company_id+"======"+type);
		Integer audit;
		if(type.equals("pass")){
			audit=1;
		}else{
			audit=2;
		}
		OiCompany company;
		try {
			company = new OiCompany();
			company.setAudit(audit);
			company.setAudit_time(new Date());
			company.setCompany_id(company_id);
			oiCompanyService.updateExamineCompany(company);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
		
	}
	/**
	 * 显示待审核列表
	 * @return
	 */
	@RequestMapping(value="/getcheckcompanylist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getCheckdCompany(BootstrapTable bootstrapTable){	
		System.out.println(bootstrapTable);
		Map<String,Object>result=new HashMap<String, Object>();
		List<OiCompany> companys=oiCompanyService.getCheckCompanyWithType(bootstrapTable);

	String jsonString = JSONArray.toJSONString(companys);		
	return jsonString;
	}
	
	/**
	 * 获取城市
	 * @param pro_id
	 * @return
	 */
	@RequestMapping(value="/findcity",method=RequestMethod.GET)
	@ResponseBody
	public Msg getcity(@RequestParam("pro_id")Integer pro_id){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria2 = districtExample.createCriteria();
		createCriteria2.andPidEqualTo(pro_id);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		return Msg.success().add("districts", district);
	}
	
	/**
	 * 获取地区
	 * @param city_id
	 * @return
	 */
	@RequestMapping(value="/findarea",method=RequestMethod.GET)
	@ResponseBody
	public Msg getarea(@RequestParam("city_id")Integer city_id){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria2 = districtExample.createCriteria();
		createCriteria2.andPidEqualTo(city_id);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		return Msg.success().add("districts", district);
	}
	
	/**
	 * 数据中心
	 * @param admin_id
	 * @return
	 */
	@RequestMapping(value="/getdata.do",method=RequestMethod.GET)
	@ResponseBody
	public Msg getData(){
		List<OiCompany> companytypes= oiCompanyService.selectCompanyTypeCount();
		List<OiCompany> companyProvinces=oiCompanyService.selectCompanyProvinceCount();
		return Msg.success().add("Type",companytypes).add("Provinces", companyProvinces);
	}
	
	/**
	 * 获取管理员
	 * @param admin_id
	 * @return
	 */
	@RequestMapping(value="/getadmin.do/{admin_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAdminById(@PathVariable("admin_id")Integer admin_id){
		OiAdmin admin = oiAdminService.getOiAdminByid(admin_id);
		return Msg.success().add("Admin",admin);
	}
	
	/**
	 * 获取管理员列表
	 * @return
	 */
	@RequestMapping(value="/getadminlist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getAdmin(BootstrapTable bootstrapTable){
		System.out.println(bootstrapTable);
		Map<String,Object>result=new HashMap<String, Object>();
		List<OiAdmin> admins=oiAdminService.getAdmin(bootstrapTable);
		String jsonString = JSONArray.toJSONString(admins);		
	return jsonString;
	}
	/**
	 * 修改管理员
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/updateadmin.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateAdmin(OiAdmin admin,HttpServletRequest request){
		GetIp ip=new GetIp();
		try{
			if(admin.getAdmin_id()==null){
				admin.setCreate_ip(ip.getIpAddress(request));
				admin.setCreate_time(new Date());
				admin.setStatus(1);
				oiAdminService.addAdmin(admin);
			}else{
			oiAdminService.updateAdmin(admin);
			}
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除管理员
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/removeadmin.do/{admin_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeAdmin(@PathVariable("admin_id")Integer admin_id){
		System.out.println(admin_id);
		try{
			OiAdmin oiAdmin=new OiAdmin();
			oiAdmin.setAdmin_id(admin_id);
			oiAdmin.setStatus(0);
			oiAdminService.removeAdmin(oiAdmin);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	
	/**
	 * 获取角色
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/getrole.do/{role_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getRoleById(@PathVariable("role_id")Integer role_id){
		OiRole oiRole = oiRoleService.getOiRoleByid(role_id);
		List<Integer> functions=new ArrayList<>();
		String[] functionsids = oiRole.getRules().split(",");
		for (String string : functionsids) {
			functions.add(Integer.parseInt(string));
		}
		OiAuthRuleExample example =new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiAuthRule> rules=oiAuthRuleService.getMenu(example);
		return Msg.success().add("Role",oiRole).add("Rules", rules);
	}
	/**
	 * 获取角色列表
	 * @return
	 */
	@RequestMapping(value="/getrolelist",method=RequestMethod.GET)
	@ResponseBody
	public Msg getRoleList(){
		OiRoleExample example=new OiRoleExample();
		cn.zx.pojo.OiRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiRole> roles=oiRoleService.getAllRole(example);
	return Msg.success().add("Roles", roles);
	}
	
	
	/**
	 * 获取角色列表
	 * @param pn
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value="/getrolelist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getRole(BootstrapTable bootstrapTable){
		Map<String,Object>result=new HashMap<String, Object>();
		List<OiRole> roles=oiRoleService.getRole(bootstrapTable);
	String jsonString = JSONArray.toJSONString(roles);	
	return jsonString;
	}
	
	/**
	 * 修改角色
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/updaterole.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateRole(OiRole oiRole){
		try{
			oiRoleService.updateRole(oiRole);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除角色
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/removerole.do/{role_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeRole(@PathVariable("role_id")Integer role_id){
		try{
			OiRole oiRole=new OiRole();
			oiRole.setO_r_id(role_id);
			oiRole.setStatus(0);
			oiRoleService.removeRole(oiRole);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 增加角色
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/addrole.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg addRole(OiRole oiRole){
		System.out.println(oiRole);
		try{
			oiRoleService.addRole(oiRole);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除公司
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/removecompany.do/{companyId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeCompany(@PathVariable("companyId") Integer companyId){
			try {
				OiCompany company=new OiCompany();
				company.setCompany_id(companyId);
				company.setIsdelete(1);
				oiCompanyService.removecompany(company);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	/**
	 * 获取公司信息
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/getcompany.do/{company_id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getcompany(@PathVariable("company_id") Integer company_id){
		List<OiType> type = oiTypeService.getType(null);
		OiCompany company = oiCompanyService.getCompanyById(company_id);
		return Msg.success().add("Type",type).add("company",company);
		}
	/**
	 * 公司审核
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/updatecompany.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateExamineCompany(OiCompany company){
		System.out.println("123");
			try {
					company.setAudit_time(new Date());
					System.out.println(company);
					oiCompanyService.updateExamineCompany(company);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	/**
	 * 显示审核列表
	 * @param pn
	 * @param search
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value="/getcompanylist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getCompany(BootstrapTable bootstrapTable){	
		Map<String,Object>result=new HashMap<String, Object>();
		List<OiCompany> companys=oiCompanyService.getCompanyWithType(bootstrapTable);
	String jsonString = JSONArray.toJSONString(companys);
	return jsonString;
	}
	

	
	/**
	 * 修改地区
	 * @return
	 */
	@RequestMapping(value="/updatedistrict.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateDistrictById(OiDistrict district){
		try{
			if(district.getDistrict_id()==null){
				OiDistrict district2 = oiDistrictService.getDistrictById(district.getPid());
				district.setLevel(district2.getLevel()+1);
				oiDistrictService.addDistrict(district);
			}else{
		oiDistrictService.updateDistrict(district);
			}
		return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
	}
	
	/**
	 * 移除地区
	 * @return
	 */
	@RequestMapping(value="/removedistrict.do/{district_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeDistrictById(@PathVariable("district_id") Integer district_id){
		try{
		OiDistrict district=new OiDistrict();
		district.setDistrict_id(district_id);
		district.setStatus(0);
		oiDistrictService.removeDistrict(district);
		return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
	}
	
	
	/**
	 * 获取地区
	 * @return
	 */
	@RequestMapping(value="/getdistrict.do/{district_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getDistrictById(@PathVariable("district_id") Integer district_id){
		OiDistrict district = oiDistrictService.getDistrictById(district_id);
		return Msg.success().add("District", district);
	}
	
	/**
	 * 获取地区列表
	 * @return
	 */
	@RequestMapping(value="/getdistrictlist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getDistrict(){
		String jsonString = JSONArray.toJSONString(DistrictTree(1));
		return jsonString;
	}
	/**
	 * 获取地区列表
	 * @return
	 */
	@RequestMapping(value="/getdistrictlist",method=RequestMethod.GET)
	@ResponseBody
	public Msg getDistrictMsg(){
		OiDistrictExample example=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		
		List<OiDistrict> childTreeNodes = oiDistrictService.getDistrict(example);
		System.out.println(childTreeNodes);
		return Msg.success().add("District",childTreeNodes);
	}
	
	
	/**
	 * 地区树
	 * @param id
	 * @return
	 */
	public OiDistrict DistrictTree(Integer id){
		OiDistrict node = oiDistrictService.getDistrictById(id);
		OiDistrictExample example=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(id);
		createCriteria.andStatusEqualTo(1);
		List<OiDistrict> childTreeNodes = oiDistrictService.getDistrict(example);
		for(OiDistrict child : childTreeNodes){
			OiDistrict n = DistrictTree(child.getDistrict_id()); //递归
		node.getNodes().add(n);
		}
		return node;
	}
	
	
	/**
	 * 增加/修改企业类型
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/updatetype.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateType(OiType oiType){
		try {
			if(oiType.getType_id()==null){
				oiType.setIsdelete(0);
				oiTypeService.addType(oiType);
			}else{
				oiTypeService.updateType(oiType);
			}
			return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 移除去企业类型
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/removetype.do/{type_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeType(@PathVariable("type_id") Integer type_id){
			try {
				OiType oiType=new OiType();
				oiType.setType_id(type_id);
				oiType.setStatus(0);
				oiTypeService.updateType(oiType);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	
	/**
	 * 查看某个企业类型
	 * @param type_id
	 * @return
	 */
	@RequestMapping(value="/gettype.do/{type_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getType(@PathVariable("type_id") Integer type_id){
		OiType oiType = oiTypeService.getTypeById(type_id);
		return Msg.success().add("OiType", oiType);
		
	}
	
	/**
	 * 获取企业类型列表
	 * @return
	 */
	@RequestMapping(value="/gettypelist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getType(){
		OiType type=TypeTree(1);
		String jsonString = JSONArray.toJSONString(type);
		System.out.println(jsonString);
		return jsonString;
	}
	
	
	
	/**
	 * 类型树
	 * @param id
	 * @return
	 */
	public OiType TypeTree(Integer id){
		OiType node = oiTypeService.getTypeById(id);
		OiTypeExample example=new OiTypeExample();
		cn.zx.pojo.OiTypeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(id);
		createCriteria.andStatusEqualTo(1);
		List<OiType> childTreeNodes = oiTypeService.getType(example);
		for(OiType child : childTreeNodes){
			OiType n = TypeTree(child.getType_id()); //递归
		node.getNodes().add(n);
		}
		return node;
	}
	
	
	/**
	 * 修改菜单
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/updaterule.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateRule(OiAuthRule oiAuthRule){
		try {
			oiAuthRuleService.updateRule(oiAuthRule);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	/**
	 * 查看某条菜单
	 * @param menu_id
	 * @return
	 */
	@RequestMapping(value="/getrulebyid.do/{menu_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectRule(@PathVariable("menu_id") Integer menu_id){
		OiAuthRule oiAuthRule = oiAuthRuleService.getRuleById(menu_id);
		return Msg.success().add("OiAuthRule", oiAuthRule);
		
	}
	
	/**
	 * 移除菜单
	 * @param menu_id
	 * @return
	 */
	@RequestMapping(value="/removerule.do/{menu_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg romoveRule(@PathVariable("menu_id") Integer menu_id){
		OiAuthRule oiAuthRule=new OiAuthRule();
		oiAuthRule.setR_id(menu_id);
		oiAuthRule.setStatus(0);
			try {
				oiAuthRuleService.removeRule(oiAuthRule);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 增加菜单
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/addrule.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg addRule(OiAuthRule oiAuthRule){
			try {
				oiAuthRule.setStatus(1);
				oiAuthRuleService.addRule(oiAuthRule);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 获取显示菜单列表
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/getrule.do",method=RequestMethod.GET)
	@ResponseBody
	public Object GetRule(){
		String jsonString = JSONArray.toJSONString(AuthRuleTree(1));
		return jsonString;
	}
	/**
	 * 菜单树
	 * @param id
	 * @return
	 */
	public OiAuthRule AuthRuleTree(Integer id){
		OiAuthRule node = oiAuthRuleService.getRuleById(id);
		OiAuthRuleExample example=new OiAuthRuleExample();
		cn.zx.pojo.OiAuthRuleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(id);
		createCriteria.andStatusEqualTo(1);
		example.setOrderByClause("o asc");
		List<OiAuthRule> childTreeNodes = oiAuthRuleService.getMenu(example);
		for(OiAuthRule child : childTreeNodes){
			OiAuthRule n = AuthRuleTree(child.getR_id()); //递归
		node.getNodes().add(n);
		}
		return node;
	}
	
	/**
	 * 修改设置信息
	 * @param oiSite
	 * @return
	 */
	@RequestMapping(value="/updatesite.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg getSite(OiSite oiSite){
		System.out.println(oiSite);
		try {
			oiSiteService.updateSite(oiSite);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	
	/**
	 * 获取后台信息
	 * @return
	 */
	@RequestMapping(value="/getsite.do",method=RequestMethod.GET)
	@ResponseBody
	public Msg getSite(){
		OiSite oiSite = oiSiteService.getoiSite().get(0);
		if(oiSite==null){
			return Msg.fail();
		}
		return Msg.success().add("OiSite", oiSite);
	}
	
}
