package cn.zx.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.pojo.CompanyDepartExample.Criteria;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyNewsService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.CompanyTaskService;
import cn.zx.service.StaffTaskLogService;
import cn.zx.util.MainWechat;

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
	@Autowired
	CompanyNewsService companyNewsService;

	// 跳转发布任务
	@RequestMapping(value = "/oi_staff_publish.html")
	public String redirectAddTask(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		String currentTime = sdf.format(new Date());
		request.setAttribute("currentTime", currentTime);
		return "staff/oi_staff_publish";
	}

	// 我接收的任务
	@RequestMapping(value = "/oi_staff_task_center.html")
	public String redirectSelectAllToUserTask() {
		return "staff/oi_staff_task_center";
	}

	// 根据公司ID查询公司部门
	@RequestMapping(value = "/oi_sf_branch.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectDepartByCompanyId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyDepartExample example = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		example.setOrderByClause("o");

		List<CompanyDepart> companyDeparts = companyDepartService.selectDepartByCompanyId(example);
		return JSONArray.toJSONString(companyDeparts);
	}

	// 根据公司ID和部门ID查询员工
	@RequestMapping(value = "/oi_sf_branch_staff.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyIdAndDepartId(String selData,HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyStafferExample example = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompanyIdEqualTo(companyStaffer.getCompany_id());
		createCriteria.andDepartEqualTo(Integer.parseInt(selData));

		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		return JSONArray.toJSONString(companyStaffers);
	}

	// 发布任务
	@RequestMapping(value = "/addTask.html", method = RequestMethod.POST)
	public String staffAddTask(String task_title, String to_user, String task_end_time, String task_urgent,
			String task_important, String task_content, HttpServletRequest request,HttpSession session) throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		Date end_time = sdf.parse(task_end_time);
		CompanyTask companyTask = new CompanyTask();
		companyTask.setCompany_id(companyStaffer.getCompany_id());
		companyTask.setUser_id(companyStaffer.getUser_id());
		companyTask.setTo_user(Integer.parseInt(to_user));
		companyTask.setTask_title(task_title);
		companyTask.setTask_end_time(end_time);
		companyTask.setTask_start_time(new Date());
		companyTask.setTask_status(5);
		companyTask.setTask_progress(0);
		companyTask.setTask_urgent(Integer.parseInt(task_urgent));
		companyTask.setTask_important(Integer.parseInt(task_important));
		companyTask.setTask_content(task_content);
		boolean flag = companyTaskService.staffAddTask(companyTask);
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			String currentTime = sdf.format(new Date());
			request.setAttribute("currentTime", currentTime);
			return "staff/oi_staff_publish";
		}
	}

	// 查询当前员工的所有任务
	@RequestMapping(value = "/selectAllTaskByToUserId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByToUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		
		List<CompanyTask> companyTasks = companyTaskService.selectTaskByUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 查询当前员工发布的所有任务
	@RequestMapping(value = "/selectAllTaskByUserId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectTaskByToUser(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 接受任务用户查询详细内容
	@RequestMapping(value = "/oi_staff_tsk_detailToUser.html")
	public String selectTaskByTaskIdToUser(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, HttpServletRequest request) {
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式

		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(Integer.parseInt(task_id));
		example.setOrderByClause("sub_time");

		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);

		if (Integer.parseInt(task_status) == 1 || Integer.parseInt(task_status) == 2
				|| Integer.parseInt(task_status) == 3 || Integer.parseInt(task_status) == 5 || Integer.parseInt(task_status) == 6) {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			request.setAttribute("staffTaskLogs", staffTaskLogs);
			return "staff/oi_staff_tsk_detail";
		} else {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			// 格式化日期
			String currentTime = sdf.format(new Date());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("currentTime", currentTime);
			request.setAttribute("task_id", task_id);
			request.setAttribute("staffTaskLogs", staffTaskLogs);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			return "staff/oi_staff_edit";
		}

	}

	// 根据发布人查看任务详情
	@RequestMapping(value = "/oi_staff_tsk_detailUser.html")
	public String selectTaskByTaskIdUser(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, HttpServletRequest request) {
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式

		if (Integer.parseInt(task_status) == 3) {
			String currentTime = sdf.format(new Date());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("currentTime", currentTime);
			return "staff/oi_staff_transpond";
		} else {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());

			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			/* request.setAttribute("staffTaskLogs",staffTaskLogs); */
			return "staff/oi_staff_tsk_detail";
		}

	}

	// 加载日志
	@RequestMapping(value = "/selectTaskLogByTaskId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectTaskLogByTaskId(String task_id) {
		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(Integer.parseInt(task_id));
		example.setOrderByClause("sub_time");

		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);
		return JSONArray.toJSONStringWithDateFormat(staffTaskLogs, "yyyy-MM-dd HH:mm");
	}

	// 修改任务状态
	@RequestMapping(value = "/oi_staff_edit.html")
	public String updateTaskStatus(String task_id, String task_status) {
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if (Integer.parseInt(task_status) == 5) {
			companyTask.setTask_status(4);
		}
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}

	}
	
	//取消任务
	@RequestMapping(value = "/oi_staff_cancel.json",method=RequestMethod.POST)
	@ResponseBody
	public boolean cancelTask(String task_id) {
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		companyTask.setTask_status(1);
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		return flag;

	}
	
	// 退回任务和拒绝退回任务
	@RequestMapping(value = "/oi_staff_return.html")
	public String returnTask(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, @RequestParam(required = false) String task_reasion,
			@RequestParam(required = false) String task_reback_reasion) throws UnsupportedEncodingException {
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if (Integer.parseInt(task_status) == 5 || Integer.parseInt(task_status) == 4) {
			String task_del_reasion = new String(task_reasion.getBytes("ISO8859-1"), "UTF-8");
			companyTask.setTask_del_reasion(task_del_reasion);
			companyTask.setTask_status(3);
		} else if (Integer.parseInt(task_status) == 3) {
			String reback_reasion = new String(task_reback_reasion.getBytes("ISO8859-1"), "UTF-8");
			companyTask.setTask_reback_reasion(reback_reasion);
			companyTask.setTask_status(5);
			;
		}
		boolean flag = companyTaskService.returnTask(companyTask);
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}

	}

	// 编辑任务进度
	@RequestMapping(value = "/updateTaskProgress.html", method = RequestMethod.POST)
	public String updateTaskProgress(String task_id, String task_progress, String nod_desc,
			HttpServletRequest request) {

		CompanyTask companyTask = new CompanyTask();
		if (Integer.parseInt(task_progress) == 100) {
			companyTask.setTask_status(6);
		}
		companyTask.setTask_id(Integer.parseInt(task_id));
		companyTask.setTask_progress(Integer.parseInt(task_progress));
		StaffTaskLog staffTaskLog = new StaffTaskLog();
		staffTaskLog.setCompany_id(1);
		staffTaskLog.setTask_id(Integer.parseInt(task_id));
		staffTaskLog.setTask_progress(Integer.parseInt(task_progress));
		staffTaskLog.setNod_desc(nod_desc);
		staffTaskLog.setSub_time(new Date());

		boolean flag = companyTaskService.updateTaskProgress(companyTask);
		boolean flag1 = staffTaskLogService.addTaskProgressLog(staffTaskLog);

		if (flag == true && flag1 == true) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}
	}
	
	//跳转评价任务
	@RequestMapping(value="/oi_staff_evaluate.html")
	public String redirectEvaluateTask(String task_id,String to_user,HttpSession session,HttpServletRequest request) throws ParseException{
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		CompanyStaffer  companyStaffer1 =companyStafferService.selectStaffByDepartAndPost(Integer.parseInt(to_user),companyStaffer.getCompany_id());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currenttime=new Date();
		Date reg_time= companyStaffer1.getReg_time();
		
		long day=0;
		Date beginDate;
		Date endDate;
		beginDate = format.parse(format.format(reg_time));
		endDate= format.parse(format.format(currenttime));    
		day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
		request.setAttribute("longtime",day);
		request.setAttribute("companyTask", companyTask);
		request.setAttribute("companyStaffer1", companyStaffer1);
		return "staff/oi_staff_evaluate";
	}
	
	//评价任务
	@RequestMapping(value="evaluateTask.do",method=RequestMethod.POST)
	public String evaluateTask(CompanyTask companyTask){
		companyTask.setTask_status(2);
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		if(flag){
			return "staff/oi_staff_task_center";
		}else{
			return "";
		}
	}

	// 转发任务
	@RequestMapping(value = "/oi_staff_transpond.html", method = RequestMethod.POST)
	public String updateToUser(CompanyTask companyTask, String end_time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		Date task_end_time = sdf.parse(end_time);
		companyTask.setTask_end_time(task_end_time);
		companyTask.setTask_status(5);
		boolean flag = companyTaskService.updateToUser(companyTask);
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}
	}

	// 查询接收任务职员待办任务
	@RequestMapping(value = "/selectAllToDOTaskByToUser.json")
	@ResponseBody
	public String selectAllToDOTaskByToUser(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(4, 5);
		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectToDOTaskByToUser(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 查询职员待办任务
	@RequestMapping(value = "/selectAllToDOTaskByUserId.json")
	@ResponseBody
	public String selectAllToDOTaskByUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(3,5);

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectToDOTaskByUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getRealname());
		}
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// =========================================================================

	// 职员修改邮箱地址
	@RequestMapping(value = "/staffUpdateEmailOrPhone.json")
	@ResponseBody
	public boolean staffUpdateEmail(@RequestParam(required = false) String email,
			@RequestParam(required = false) String phone,HttpSession session) {
		CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyStaffer companyStaffer = new CompanyStaffer();
		companyStaffer.setUser_id(companyStaff.getUser_id());
		if (email != null) {
			companyStaffer.setEmail(email);
		}
		if (phone != null) {
			companyStaffer.setPhone(phone);
		}
		boolean flag = companyStafferService.staffUpdateEmailOrTelphone(companyStaffer);
		return flag;
	}

	// 根据公司Id查询所有职员

	// 跳转消息中心
	@RequestMapping(value = "/oi_staff_msg.html")
	public String redirectStaffMsg() {
		return "staff/oi_staff_msg";
	}

	// 跳转统计
	@RequestMapping(value = "/oi_staff_data_center.html")
	public String redirectStaffDataCenter() {
		return "staff/oi_staff_data_center";
	}

	// 跳转个人中心
	@RequestMapping(value = "/oi_staff_info.html")
	public String redirectStaffInfo(HttpServletRequest request,HttpSession session) throws ParseException {
		CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),companyStaff.getCompany_id());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currenttime=new Date();
		Date reg_time= companyStaff.getReg_time();
		
		long day=0;
		Date beginDate;
		Date endDate;
		beginDate = format.parse(format.format(reg_time));
		endDate= format.parse(format.format(currenttime));    
		day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
		request.setAttribute("longtime",day);
		request.setAttribute("conCompanyStaffer", conCompanyStaffer);
		return "staff/oi_staff_info";
	}

	// 跳转通讯录
	@RequestMapping(value = "/oi_staff_contact.html")
	public String redirectContact() {
		return "staff/oi_staff_contact";
	}

	// 跳转我的名片
	@RequestMapping(value = "/oi_staff_busCard.html")
	public String redirectStaffBusCard() {
		return "staff/oi_staff_busCard";
	}
	
	//企业公告信息
	@RequestMapping(value="/selectCompanyNews")
	@ResponseBody
	public String selectCompanyNews(HttpSession session){
		CompanyStaffer companyStaffer= (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyNewsExample example = new CompanyNewsExample();
		cn.zx.pojo.CompanyNewsExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		List<CompanyNews> companyNews = companyNewsService.selectAllCompanyNewsByCompanyId(example);
		return JSONArray.toJSONStringWithDateFormat(companyNews,"yyyy-MM-dd HH:mm");
	}
	
	//查询所有信息条数
	@RequestMapping(value="selectNewsCount.json",method=RequestMethod.POST)
	@ResponseBody
	public int selectNewsCount(HttpSession session){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(4, 5);
		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		
		
		cn.zx.pojo.CompanyTaskExample example1 = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria1 = example1.createCriteria();
		createCriteria1.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria1.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria1.andTask_statusBetween(3,5);

		List<CompanyTask> companyTasks1 = companyTaskService.selectAllTaskByToUserId(example1);
		
		cn.zx.pojo.CompanyNewsExample example2 = new CompanyNewsExample();
		cn.zx.pojo.CompanyNewsExample.Criteria createCriteria2 = example2.createCriteria();
		createCriteria2.andCompany_idEqualTo(companyStaffer.getCompany_id());
		List<CompanyNews> companyNews = companyNewsService.selectAllCompanyNewsByCompanyId(example2);
		
		int TaskByToUserIdCount=companyTasks.size();
		int TaskByToUserId=companyTasks1.size();
		int CompanyNewsByCompanyIdCount=companyNews.size();
		
		int allNewsCount = TaskByToUserIdCount+TaskByToUserId+CompanyNewsByCompanyIdCount;
		return allNewsCount;
	}
	
	
	//根据公司Id查询所有人
	@RequestMapping(value="/selectStaffByCompanyId",method=RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyId(HttpSession session){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyId(companyStaffer.getCompany_id());
		return JSONArray.toJSONString(companyStaffers);
	}
	
	//根据任务状态查询任务
	@RequestMapping(value="/selectTaskByTaskStatus.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectTaskByTaskStatus(String type,String task_status,HttpSession session){
		
		System.out.println(type);
		System.out.println(task_status);
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		if(Integer.parseInt(task_status)!=0){
			createCriteria.andTask_statusEqualTo(Integer.parseInt(task_status));
		}*/
		List<CompanyTask> companyTasks = null;
		if(Integer.parseInt(type)==1){
			/*createCriteria.andUser_idEqualTo(companyStaffer.getUser_id());*/
			 companyTasks = companyTaskService.selectTaskByStatusAndUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id(),Integer.parseInt(task_status));
		}else if(Integer.parseInt(type)==2){
			/*createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());*/
			 companyTasks = companyTaskService.selectTaskByStatusAndToUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id(),Integer.parseInt(task_status));
		}
		/*List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByTaskStatus(example);*/
		return JSONArray.toJSONStringWithDateFormat(companyTasks,"yyyy-MM-dd HH:mm");
		
	}
	
	
	
	@RequestMapping(value="/tmpl.html")
	public String tmpl(String to_user,String tmplId,HttpSession session){
		System.out.println(to_user+"========"+tmplId+"========");
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		MainWechat m = new MainWechat();
		System.out.println();
		m.task(companyStaffer.getCompany_id(),Integer.parseInt(to_user), Integer.parseInt(tmplId));
		return "staff/oi_staff_task_center";
	}

}
