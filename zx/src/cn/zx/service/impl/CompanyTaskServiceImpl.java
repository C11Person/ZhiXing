package cn.zx.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyTaskMapper;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.service.CompanyTaskService;

@Service("companyTaskService")
public class CompanyTaskServiceImpl implements CompanyTaskService {
	@Autowired
	CompanyTaskMapper companyTaskMapper;
	
	@Override
	public List<CompanyTask> selectTask(@Param("company_id") Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectTask(company_id);
	}
	@Override
	public boolean staffAddTask(CompanyTask companyTask) {
		return companyTaskMapper.insertSelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllTaskByToUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public CompanyTask selectTaskByTaskId(Integer task_id) {
		return companyTaskMapper.selectByPrimaryKey(task_id);
	}

	@Override
	public boolean updateTaskStatus(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public boolean updateTaskProgress(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public boolean updateToUser(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllToDOTaskByToUser(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectAllToDOTaskByUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectAllTaskByUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public boolean returnTask(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllTaskByTaskStatus(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectTaskByUserId(Integer company_id, Integer to_user) {
		return companyTaskMapper.selectTaskByUserId(company_id, to_user);
	}

	@Override
	public List<CompanyTask> selectTaskByToUser(Integer company_id, Integer user_id) {
		return companyTaskMapper.selectTaskByToUser(company_id, user_id);
	}

	@Override
	public List<CompanyTask> selectToDOTaskByUserId(Integer company_id, Integer user_id) {
		return companyTaskMapper.selectToDOTaskByUserId(company_id, user_id);
	}

	@Override
	public List<CompanyTask> selectToDOTaskByToUser(Integer company_id, Integer uesr_id) {
		return companyTaskMapper.selectToDOTaskByToUser(company_id, uesr_id);
	}

	@Override
	public List<CompanyTask> selectTaskByStatusAndUserId(Integer company_id, Integer user_id, Integer task_status) {	
		return companyTaskMapper.selectTaskByStatusAndUserId(company_id, user_id, task_status);
	}

	@Override
	public List<CompanyTask> selectTaskByStatusAndToUserId(Integer company_id, Integer to_user, Integer task_status) {
		return companyTaskMapper.selectTaskByStatusAndToUserId(company_id, to_user, task_status);
	}
}
