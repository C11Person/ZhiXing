package cn.zx.dao;

import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.pojo.CompanyPromotionMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPromotionMsgMapper {
    long countByExample(CompanyPromotionMsgExample example);

    int deleteByExample(CompanyPromotionMsgExample example);

    int deleteByPrimaryKey(Integer promotion_msg_id);

    int insert(CompanyPromotionMsg record);

    int insertSelective(CompanyPromotionMsg record);

    List<CompanyPromotionMsg> selectByExample(CompanyPromotionMsgExample example);

    CompanyPromotionMsg selectByPrimaryKey(Integer promotion_msg_id);

    int updateByExampleSelective(@Param("record") CompanyPromotionMsg record, @Param("example") CompanyPromotionMsgExample example);

    int updateByExample(@Param("record") CompanyPromotionMsg record, @Param("example") CompanyPromotionMsgExample example);

    int updateByPrimaryKeySelective(CompanyPromotionMsg record);

    int updateByPrimaryKey(CompanyPromotionMsg record);
}