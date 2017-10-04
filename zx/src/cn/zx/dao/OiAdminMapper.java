package cn.zx.dao;

import cn.zx.pojo.BootstrapTable;
import cn.zx.pojo.OiAdmin;
import cn.zx.pojo.OiAdminExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OiAdminMapper {
    long countByExample(OiAdminExample example);

    int deleteByExample(OiAdminExample example);

    int deleteByPrimaryKey(Integer admin_id);

    int insert(OiAdmin record);

    int insertSelective(OiAdmin record);

    List<OiAdmin> selectByExample(OiAdminExample example);

    OiAdmin selectByPrimaryKey(Integer admin_id);

    int updateByExampleSelective(@Param("record") OiAdmin record, @Param("example") OiAdminExample example);

    int updateByExample(@Param("record") OiAdmin record, @Param("example") OiAdminExample example);

    int updateByPrimaryKeySelective(OiAdmin record);

    int updateByPrimaryKey(OiAdmin record);

    List<OiAdmin> selectAdmin(BootstrapTable bootstrapTable);
}