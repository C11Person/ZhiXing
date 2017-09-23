package cn.zx.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;
import cn.zx.pojo.CompanyDepartExample.Criteria;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.CompanyTaskService;
import cn.zx.service.StaffTaskLogService;

public class CompanyTaskTest {
	@Test
	public void  show(){
		
		//职员修改邮箱
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyTaskService  companyTaskService = (CompanyTaskService) context.getBean("companyTaskService");
		CompanyStafferService  companyStafferService = (CompanyStafferService) context.getBean("companyStafferService");
		/*CompanyStaffer companyStaffer = new CompanyStaffer();
		companyStaffer.setUser_id(1);
		companyStaffer.setEmail("123456@qq.com");
		boolean flag = companyStafferService.staffUpdateEmailOrTelphone(companyStaffer);
		if(flag){
			System.out.println("修改邮箱成功");
		}else{
			System.out.println("修改邮箱失败");
		}*/
		
/*		CompanyStaffer companyStaffer = new CompanyStaffer();
		companyStaffer.setUser_id(1);
		companyStaffer.setPhone("19999999999");
		boolean flag = companyStafferService.staffUpdateEmailOrTelphone(companyStaffer);
		if(flag){
			System.out.println("修改手机号成功");
		}else{
			System.out.println("修改手机号失败");
		}*/
		
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(1);
		companyTask.setTask_del_reasion("不想做");
		companyTask.setTask_status(3);
		boolean flag = companyTaskService.returnTask(companyTask);
		if(flag){
			System.out.println("退回任务成功");
		}else{
			System.out.println("退回任务失败");
		}
		
/*		//查询待办任务
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyTaskService  companyTaskService = (CompanyTaskService) context.getBean("companyTaskService");
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		createCriteria.andUser_idEqualTo(1);
		createCriteria.andTask_statusBetween(1,3);
		 
		 List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		 for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_title());
		}*/
		
/*		//转发任务
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyTaskService  companyTaskService = (CompanyTaskService) context.getBean("companyTaskService");
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(1);
		companyTask.setTo_user(2);
		boolean flag = companyTaskService.updateToUser(companyTask);
		if(flag){
			System.out.println("转发任务成功");
		}else{
			System.out.println("转发任务失败");
		}*/
		
		/*//修改任务进度
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyTaskService  companyTaskService = (CompanyTaskService) context.getBean("companyTaskService");
		StaffTaskLogService  staffTaskLogService = (StaffTaskLogService) context.getBean("staffTaskLogService");
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
		if(flag && flag1){
			System.out.println("修改任务进度成功");
			for (int i = 0; i < staffTaskLogs.size(); i++) {
				System.out.println(staffTaskLogs.get(i).getNod_desc());
			}
		}else{
			System.out.println("修改任务进度失败");
		}*/
		
/*		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(1);
		companyTask.setTask_status(2);;
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		if(flag){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}*/
		
/*		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(2);
		System.out.println(companyTask.getTask_title());*/
/*		 cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		 cn.zx.pojo.CompanyTaskExample.Criteria createCriteria =example.createCriteria();
		 createCriteria.andTo_userEqualTo(1);
		 example.setOrderByClause("task_start_time");
		 
		 List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		 for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getTask_title());
		}*/
/*		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyTaskService  companyTaskService = (CompanyTaskService) context.getBean("companyTaskService");
		CompanyTask companyTask = new CompanyTask();
		companyTask.setCompany_id(1);
		companyTask.setUser_id(2);
		boolean flag = companyTaskService.staffAddTask(companyTask);
		if(flag){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}*/
		
/*		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyDepartService  companyDepartService = (CompanyDepartService) context.getBean("companyDepartService");
		
		CompanyDepartExample example = new CompanyDepartExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		
		List<CompanyDepart> companyDeparts = companyDepartService.selectDepartByCompanyId(example);
		
		for (int i = 0; i < companyDeparts.size(); i++) {
			System.out.println(companyDeparts.get(i).getDept_name());
		}*/
		
/*		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CompanyStafferService  companyStafferService = (CompanyStafferService) context.getBean("companyStafferService");
		cn.zx.pojo.CompanyStafferExample example = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(1);
		createCriteria.andDepartEqualTo(4);
		
		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		for (int i = 0; i < companyStaffers.size(); i++) {
			System.out.println(companyStaffers.get(i).getRealname());
		}*/
	}
}
