package cn.zx.dao;

import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyPropagandaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPropagandaMapper {
	/**
	 * 修改企业宣传
	 * @param record
	 * @return
	 */
    int updateByPrimaryKeySelective(CompanyPropaganda record);
    /**
     * 查询企业宣传
     * @param company_id
     * @return
     */
    public List<CompanyPropaganda> selectPropaganda(@Param("p_id") Integer p_id,@Param("company_id") Integer company_id);
    /**
     * 插入信息
     * @param record
     * @return
     */
    public int insertPropaganda(CompanyPropaganda record);
}