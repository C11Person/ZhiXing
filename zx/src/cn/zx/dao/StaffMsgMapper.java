package cn.zx.dao;

import cn.zx.pojo.StaffMsg;
import cn.zx.pojo.StaffMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMsgMapper {
    long countByExample(StaffMsgExample example);

    int deleteByExample(StaffMsgExample example);

    int deleteByPrimaryKey(Integer s_m_id);

    int insert(StaffMsg record);

    int insertSelective(StaffMsg record);

    List<StaffMsg> selectByExample(StaffMsgExample example);

    StaffMsg selectByPrimaryKey(Integer s_m_id);

    int updateByExampleSelective(@Param("record") StaffMsg record, @Param("example") StaffMsgExample example);

    int updateByExample(@Param("record") StaffMsg record, @Param("example") StaffMsgExample example);

    int updateByPrimaryKeySelective(StaffMsg record);

    int updateByPrimaryKey(StaffMsg record);
}