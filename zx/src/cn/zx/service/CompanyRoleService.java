package cn.zx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyRole;

public interface CompanyRoleService {
	
	 public List<CompanyRole> selectRole( Integer user_id, Integer company_id);

	 public int updateByPrimaryKeySelective(List<CompanyRole> list);
	 
	 public int insertSelective(CompanyRole record);
}
