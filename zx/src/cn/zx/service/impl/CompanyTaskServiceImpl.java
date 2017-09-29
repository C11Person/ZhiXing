/**
 * 
 */
package cn.zx.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyTaskMapper;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.service.CompanyTaskService;

/**
 * @author AYao
 *
 */
@Service("companyTaskService")
public class CompanyTaskServiceImpl implements CompanyTaskService {
	@Autowired
	private CompanyTaskMapper companyTaskMapper;

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

	/*@Override
	public List<CompanyTask> selectTaskByVaguename(String vaguename) {
		return companyTaskMapper.selectTaskByVaguename(vaguename);
	}*/

	
}
