package cn.zx.dao;

import cn.zx.pojo.CompanyBasic;
import cn.zx.pojo.CompanyBasicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 公司基础信息Dao层接口
 * @author admin
 *
 */
public interface CompanyBasicMapper {
	/**
	 * 查询公司基础信息
	 * @param company_id
	 * @return
	 */
    public CompanyBasic selectBasic(@Param("company_id") Integer company_id);
    
    /**
     * 修改企业信息根据ID
     * @param companyBasic
     * @return
     */
    public int updateBasicByID(CompanyBasic companyBasic);
}