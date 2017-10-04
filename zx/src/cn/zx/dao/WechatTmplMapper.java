package cn.zx.dao;

import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatTmplMapper {
	/**
	 * 修改信息根据ID
	 * @param record
	 * @return
	 */
    public int updateByPrimaryKeySelective(WechatTmpl record);
    
    /**
     * 查询信息
     * @param record
     * @return
     */
    public List<WechatTmpl> selectWechatTmpl(WechatTmpl record);
    /**
     * 添加一条信息
     * @param record
     * @return
     */
    public int insertWechatTmpl(WechatTmpl record);
    
}