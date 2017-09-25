package cn.zx.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyDepartExample.Criteria;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.CompanyTaskService;
import cn.zx.service.StaffTaskLogService;

@RequestMapping(value = "/staff")
@Controller
public class OiStaffController {
	@Autowired
	CompanyTaskService companyTaskService;
	@Autowired
	CompanyDepartService companyDepartService;
	@Autowired
	CompanyStafferService companyStafferService;
	@Autowired
	StaffTaskLogService staffTaskLogService;
	
	//跳转发布任务
	@RequestMapping(value="/staffAddTask.html")
	public String redirectAddTask(){
		return "staff/oi_staff_publish";
	}
	
	//我接收的任务
	@RequestMapping(value="/selectAllToUserTask.html")
	public String redirectSelectAllToUserTask(){
		return "staff/oi_staff_task_center";
	}
	
	//根据公司ID查询公司部门
	@RequestMapping(value="/oi_sf_branch.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectDepartByCompanyId(){
		cn.zx.pojo.CompanyDepartExample example = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		example.setOrderByClause("o");
		
		List<CompanyDepart> companyDeparts = companyDepartService.selectDepartByCompanyId(example);
		return JSONArray.toJSONString(companyDeparts);
	}
	
	//根据公司ID和部门ID查询员工
	@RequestMapping(value="/oi_sf_branch_staff.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyIdAndDepartId(String selData){
		System.out.println("fsdafsaf"+selData);
		cn.zx.pojo.CompanyStafferExample example = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		createCriteria.andDepartEqualTo(Integer.parseInt(selData));
		
		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		return JSONArray.toJSONString(companyStaffers);
	}
	
	
	//发布任务
/*	@RequestMapping(value="")
	public String staffAddTask(CompanyTask companyTask){
		companyTask.setTask_start_time(new Date());
		companyTask.setTask_status(1);
		boolean flag = companyTaskService.staffAddTask(companyTask);
		if(flag){
			return "";
		}else{
			return "";
		}
	}*/
	
	//查询当前员工的所有任务
	@RequestMapping(value="/selectAllTaskByToUserId.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByToUserId(){
		 cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		 cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		 createCriteria.andTo_userEqualTo(1);
		 createCriteria.andCompany_idEqualTo(1);//公司ID
		 example.setOrderByClause("task_start_time");
		 
		 List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		 for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_start_time());
		}
		 return JSONArray.toJSONStringWithDateFormat(companyTasks,"yyyy-MM-dd hh:mm:ss");
	}
	
	//查询当前员工发布的所有任务
	@RequestMapping(value="/selectAllTaskByUserId.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByUserId(){
		 cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		 cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		 createCriteria.andUser_idEqualTo(1);
		 createCriteria.andCompany_idEqualTo(1);//公司ID
		 example.setOrderByClause("task_start_time");
		 
		 List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByUserId(example);
		 for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_title());
		}
		 return JSONArray.toJSONStringWithDateFormat(companyTasks,"yyyy-MM-dd hh:mm:ss");
	}
	
	//根据任务Id查询详细内容
	@RequestMapping(value="/oi_staff_tsk_detail.html")
	public String selectTaskByTaskId(String task_id,String typeId,HttpServletRequest request){
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		
		if(Integer.parseInt(typeId)==1){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 设置日期格式
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			return "staff/oi_staff_tsk_detail";
		}else if(Integer.parseInt(typeId)==2){
			
		}

	}
	
	
	//修改任务状态
	@RequestMapping(value="/oi_staff_edit.html")
	public String updateTaskStatus(String task_id,String task_status){
		System.out.println(task_id+"fdsfdfs"+task_status);
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if(Integer.parseInt(task_status)==5){
			companyTask.setTask_status(4);
		}
		
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		if(flag){
			return "staff/oi_staff_task_center";
		}else{
			return "";
		}
		
	}
	
	//退回任务和拒绝退回任务
	@RequestMapping(value="/oi_staff_return.html")
	public String returnTask(@RequestParam(required = false) String task_id,@RequestParam(required = false) String task_status,@RequestParam(required = false) String task_reasion,@RequestParam(required = false) String task_reback_reasion) throws UnsupportedEncodingException{
		
		
		System.out.println(task_id+"=========="+task_status+"====");
		
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if(Integer.parseInt(task_status)==5 || Integer.parseInt(task_status)==4){
			String task_del_reasion=new String(task_reasion.getBytes("ISO8859-1"),"UTF-8");
			companyTask.setTask_del_reasion(task_del_reasion);
			companyTask.setTask_status(3);
		}else if(Integer.parseInt(task_status)==3){
			String reback_reasion=new String(task_reback_reasion.getBytes("ISO8859-1"),"UTF-8");
			companyTask.setTask_reback_reasion(reback_reasion);
			companyTask.setTask_status(5);;
		}
		boolean flag = companyTaskService.returnTask(companyTask);
		if(flag){
			return "staff/oi_staff_task_center";
		}else{
			return "";
		}
		
	}
	
	//编辑任务进度
/*	public String updateTaskProgress(){
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(1);
		companyTask.setTask_progress(20);
		StaffTaskLog staffTaskLog = new StaffTaskLog();
		staffTaskLog.setCompany_id(1);
		staffTaskLog.setTask_id(1);
		staffTaskLog.setTask_progress(20);
		staffTaskLog.setNod_desc("测试1完成");
		staffTaskLog.setSub_time(new Date());
		
		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(1);
		example.setOrderByClause("sub_time");
		
		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);
		
		boolean flag = companyTaskService.updateTaskProgress(companyTask);
		boolean flag1 = staffTaskLogService.addTaskProgressLog(staffTaskLog);
	}*/
	
	//跳转转发任务
	@RequestMapping(value="/oi_staff_transpond.html")
	public String redirectUpdateToUser(String task_id){
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		
	}
	
	//转发任务
	public String updateToUser(){
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(1);
		companyTask.setTo_user(2);
		boolean flag = companyTaskService.updateToUser(companyTask);
	}
	
	//查询接收任务职员待办任务
/*	public String selectAllToDOTaskByToUser(){
		 cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		 cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		 createCriteria.andCompany_idEqualTo(1);
		 createCriteria.andTo_userEqualTo(1);
		 createCriteria.andTask_statusBetween(1,3);
		 
		 List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
	}*/
	
	//查询职员待办任务
/*	public String selectAllToDOTaskByUserId(){
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		createCriteria.andUser_idEqualTo(1);
		createCriteria.andTask_statusBetween(1,3);
		
		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
	}*/
	
	
	//=========================================================================
	
	//职员修改邮箱地址
/*	public String staffUpdateEmailOrTelphone(){
		CompanyStaffer companyStaffer = new CompanyStaffer();
		companyStaffer.setUser_id(1);
		companyStaffer.setEmail("123456@qq.com");
		boolean flag = companyStafferService.staffUpdateEmailOrTelphone(companyStaffer);
	}*/
	
	
	//根据公司Id查询所有职员
	
	
}
