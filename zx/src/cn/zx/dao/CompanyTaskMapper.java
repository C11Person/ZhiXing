package cn.zx.dao;

import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyTaskMapper {
    long countByExample(CompanyTaskExample example);

    int deleteByExample(CompanyTaskExample example);

    int deleteByPrimaryKey(Integer task_id);

    int insert(CompanyTask record);

    int insertSelective(CompanyTask record);

    List<CompanyTask> selectByExample(CompanyTaskExample example);

    CompanyTask selectByPrimaryKey(Integer task_id);

    int updateByExampleSelective(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByExample(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByPrimaryKeySelective(CompanyTask record);

    int updateByPrimaryKey(CompanyTask record);
    
    /*List<CompanyTask> selectTaskByVaguename(@Param("vaguename") String vaguename);*/
    
    List<CompanyTask> selectTaskByUserId(@Param("company_id") Integer company_id,@Param("to_user") Integer to_user);
    
    List<CompanyTask> selectTaskByToUser(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectToDOTaskByUserId(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectToDOTaskByToUser(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectTaskByStatusAndUserId(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id,@Param("task_status") Integer task_status);
    
    List<CompanyTask> selectTaskByStatusAndToUserId(@Param("company_id") Integer company_id,@Param("to_user") Integer to_user,@Param("task_status") Integer task_status);

    /*企业*/
    /**
     * 查询信息
     * @param company_id
     * @return
     */
    List<CompanyTask> selectTask(@Param("company_id") Integer company_id);
    
    /**
     * 按月查询总数 
     * @param company_id
     * @return
     */
    List<CompanyTask> selectCountMonth(@Param("company_id") Integer company_id);
    
    /**
     * 完成按月查询
     * @param company_id
     * @return
     */
    List<CompanyTask> selectAccomplishMonth(@Param("company_id") Integer company_id);
    /**
     * 进行按月查询
     * @param company_id
     * @return
     */
    List<CompanyTask> selectCarryMonth(@Param("company_id") Integer company_id);
    
}