package cn.zx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;

public interface CompanyStafferService {
	/**
     * 查询
     * @param user_id
     * @param company_id
     * @return
     */
    public List<CompanyStaffer> selectStaffer( Integer user_id, Integer company_id);
    
    /**
     * 添加
     * @param record
     * @return
     */
    public int insertSelective(CompanyStaffer record);
    
    /**
     * 修改
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(List<CompanyStaffer> list);
    /**
     * 根据公司ID和部门ID查询员工
     */
	List<CompanyStaffer> selectStaffByCompanyIdAndDepartId(CompanyStafferExample companyStafferExample);
	
	/**
	 * 职员修改邮箱地址、手机号
	 */
	boolean staffUpdateEmailOrTelphone(CompanyStaffer companyStaffer);
	
	/**
	 * 根据职员Id查询当前职员信息
	 */
	CompanyStaffer selectStafferByUserId(Integer user_id);
	
	/**
	 * 登陆
	 */
	List<CompanyStaffer> staffLogin(CompanyStafferExample companyStafferExample);
	
	/**
	 * 查询职员所属部门职系职级
	 */
	CompanyStaffer selectStaffByDepartAndPost(@Param("user_id") Integer user_id,@Param("company_id") Integer company_id);
	
	/**
	 * 根据公司Id查询所有人
	 */
	 List<CompanyStaffer> selectStaffByCompanyId(@Param("company_id") Integer company_id);
}
