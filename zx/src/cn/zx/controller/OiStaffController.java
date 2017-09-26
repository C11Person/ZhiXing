package cn.zx.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
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
import org.springframework.web.multipart.MultipartFile;

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

	// 跳转发布任务
	@RequestMapping(value = "/staffAddTask.html")
	public String redirectAddTask(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		String currentTime = sdf.format(new Date());
		request.setAttribute("currentTime", currentTime);
		return "staff/oi_staff_publish";
	}

	// 我接收的任务
	@RequestMapping(value = "/selectAllToUserTask.html")
	public String redirectSelectAllToUserTask() {
		return "staff/oi_staff_task_center";
	}

	// 根据公司ID查询公司部门
	@RequestMapping(value = "/oi_sf_branch.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectDepartByCompanyId() {
		cn.zx.pojo.CompanyDepartExample example = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		example.setOrderByClause("o");

		List<CompanyDepart> companyDeparts = companyDepartService.selectDepartByCompanyId(example);
		return JSONArray.toJSONString(companyDeparts);
	}

	// 根据公司ID和部门ID查询员工
	@RequestMapping(value = "/oi_sf_branch_staff.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyIdAndDepartId(String selData) {
		System.out.println("fsdafsaf" + selData);
		cn.zx.pojo.CompanyStafferExample example = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		createCriteria.andDepartEqualTo(Integer.parseInt(selData));

		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		return JSONArray.toJSONString(companyStaffers);
	}

	// 发布任务
	@RequestMapping(value = "/addTask.html", method = RequestMethod.POST)
	public String staffAddTask(String task_title, String to_user, String task_end_time, String task_urgent,
			String task_important, String task_content, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) throws ParseException {
		System.out.println(task_end_time + "1111111111111111111111");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		Date end_time = sdf.parse(task_end_time);
		CompanyTask companyTask = new CompanyTask();
		companyTask.setCompany_id(1);
		companyTask.setUser_id(1);
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
	public String selectAllTaskByToUserId() {
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTo_userEqualTo(1);
		createCriteria.andCompany_idEqualTo(1);// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_start_time());
		}
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 查询当前员工发布的所有任务
	@RequestMapping(value = "/selectAllTaskByUserId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByUserId() {
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUser_idEqualTo(1);
		createCriteria.andCompany_idEqualTo(1);// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByUserId(example);
		for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_title());
		}
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
				|| Integer.parseInt(task_status) == 3) {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			request.setAttribute("staffTaskLogs",staffTaskLogs);
			return "staff/oi_staff_tsk_detail";
		} else {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			// 格式化日期
			String currentTime = sdf.format(new Date());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("currentTime", currentTime);
			request.setAttribute("task_id",task_id);
			request.setAttribute("staffTaskLogs",staffTaskLogs);
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
		// 格式化日期
		String startTime = sdf.format(companyTask.getTask_start_time());
		String endTime = sdf.format(companyTask.getTask_end_time());
		
		
/*		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(Integer.parseInt(task_id));
		example.setOrderByClause("sub_time");

		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);*/
		
		request.setAttribute("companyTask", companyTask);
		request.setAttribute("task_start_time", startTime);
		request.setAttribute("task_end_time", endTime);
		/*request.setAttribute("staffTaskLogs",staffTaskLogs);*/
		return "staff/oi_staff_tsk_detail";

	}
	
	//加载日志
	@RequestMapping(value = "/selectTaskLogByTaskId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectTaskLogByTaskId(String task_id) {
		System.out.println("==================================="+task_id);
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
		System.out.println(task_id + "fdsfdfs" + task_status);
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

	// 退回任务和拒绝退回任务
	@RequestMapping(value = "/oi_staff_return.html")
	public String returnTask(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, @RequestParam(required = false) String task_reasion,
			@RequestParam(required = false) String task_reback_reasion) throws UnsupportedEncodingException {

		System.out.println(task_id + "==========" + task_status + "====");

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
	@RequestMapping(value="/updateTaskProgress.html",method=RequestMethod.POST)
	public String updateTaskProgress(String task_id,String task_progress,String nod_desc,HttpServletRequest request) {

		
		CompanyTask companyTask = new CompanyTask();
		if(Integer.parseInt(task_progress)==100){
			companyTask.setTask_status(2);
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
		
		if(flag==true && flag1==true){
			return "staff/oi_staff_task_center";
		}else{
			return "";
		}
	}

	// 转发任务
	/*
	 * public String updateToUser(){ CompanyTask companyTask = new
	 * CompanyTask(); companyTask.setTask_id(1); companyTask.setTo_user(2);
	 * boolean flag = companyTaskService.updateToUser(companyTask); }
	 */

	// 查询接收任务职员待办任务
	/*
	 * public String selectAllToDOTaskByToUser(){ cn.zx.pojo.CompanyTaskExample
	 * example = new CompanyTaskExample();
	 * cn.zx.pojo.CompanyTaskExample.Criteria createCriteria
	 * =example.createCriteria(); createCriteria.andCompany_idEqualTo(1);
	 * createCriteria.andTo_userEqualTo(1);
	 * createCriteria.andTask_statusBetween(1,3);
	 * 
	 * List<CompanyTask> companyTasks =
	 * companyTaskService.selectAllTaskByToUserId(example); }
	 */

	// 查询职员待办任务
	/*
	 * public String selectAllToDOTaskByUserId(){ cn.zx.pojo.CompanyTaskExample
	 * example = new CompanyTaskExample();
	 * cn.zx.pojo.CompanyTaskExample.Criteria createCriteria
	 * =example.createCriteria(); createCriteria.andCompany_idEqualTo(1);
	 * createCriteria.andUser_idEqualTo(1);
	 * createCriteria.andTask_statusBetween(1,3);
	 * 
	 * List<CompanyTask> companyTasks =
	 * companyTaskService.selectAllTaskByToUserId(example); }
	 */

	// =========================================================================

	// 职员修改邮箱地址
	/*
	 * public String staffUpdateEmailOrTelphone(){ CompanyStaffer companyStaffer
	 * = new CompanyStaffer(); companyStaffer.setUser_id(1);
	 * companyStaffer.setEmail("123456@qq.com"); boolean flag =
	 * companyStafferService.staffUpdateEmailOrTelphone(companyStaffer); }
	 */

	// 根据公司Id查询所有职员

}
