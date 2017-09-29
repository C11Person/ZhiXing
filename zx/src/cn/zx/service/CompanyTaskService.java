package cn.zx.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.StaffTaskLog;

public interface CompanyTaskService {
	/**
	 * 职员发布任务
	 * @param companyTask
	 * @return
	 */
	boolean staffAddTask(CompanyTask companyTask);
	
	/**
	 * 根据职员Id查询所属所有任务
	 */
	List<CompanyTask> selectAllTaskByToUserId(CompanyTaskExample companyTaskExample);
	
	/**
	 * 根据任务Id查询详细内容
	 */
	CompanyTask selectTaskByTaskId(Integer task_id);
	
	/**
	 * 职员接收任务
	 */
	boolean updateTaskStatus(CompanyTask companyTask);
	
	/**
	 * 编辑任务进度
	 */
	boolean updateTaskProgress(CompanyTask companyTask);
	
	/**
	 * 转发任务
	 */
	boolean updateToUser(CompanyTask companyTask);
	
	/**
	 * 查询接受任务职员待办任务
	 */
	List<CompanyTask> selectAllToDOTaskByToUser(CompanyTaskExample companyTaskExample);
	
	/**
	 * 查询职员待办任务
	 */
	List<CompanyTask> selectAllToDOTaskByUserId(CompanyTaskExample companyTaskExample);
	
	/**
	 * 根据职员Id查询发布的所有任务
	 */
	List<CompanyTask> selectAllTaskByUserId(CompanyTaskExample companyTaskExample);
	
	/**
	 * 职员退回任务
	 */
	boolean returnTask(CompanyTask companyTask);
	
	/**
	 * 多字段模糊
	 */
	/*List<CompanyTask> selectTaskByVaguename(@Param("vaguename") String vaguename);*/

}