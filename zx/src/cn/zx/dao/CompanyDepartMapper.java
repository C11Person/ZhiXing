package cn.zx.dao;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CompanyDepartMapper {
    long countByExample(CompanyDepartExample example);

    int deleteByExample(CompanyDepartExample example);

    int deleteByPrimaryKey(Integer dept_id);

    int insert(CompanyDepart record);

    int insertSelective(CompanyDepart record);

    List<CompanyDepart> selectByExample(CompanyDepartExample example);

    CompanyDepart selectByPrimaryKey(Integer dept_id);

    int updateByExampleSelective(@Param("record") CompanyDepart record, @Param("example") CompanyDepartExample example);

    int updateByExample(@Param("record") CompanyDepart record, @Param("example") CompanyDepartExample example);

    int updateByPrimaryKeySelective(CompanyDepart record);

    int updateByPrimaryKey(CompanyDepart record);
    /**
     * 树形结构查询
     * @param para
     * @return
     */
    public List<CompanyDepart> list(Map<String,Object> para);
    
    /**
     * 查询所有名称
     * @param company_id
     * @return
     */
    public List<CompanyDepart> selectDeptName(@Param("dept_id") Integer dept_id,@Param("company_id") Integer company_id);

}