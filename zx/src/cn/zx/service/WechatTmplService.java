package cn.zx.service;

import java.util.List;

import cn.zx.pojo.WechatTmpl;


public interface WechatTmplService {
	/**
	 * 修改信息根据ID
	 * @param record
	 * @return
	 */
	 public int updateByPrimaryKeySelective(List<WechatTmpl> list);
    
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
