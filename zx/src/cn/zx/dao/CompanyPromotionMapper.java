package cn.zx.dao;

import cn.zx.pojo.CompanyPromotion;
import cn.zx.pojo.CompanyPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyPromotionMapper {
    long countByExample(CompanyPromotionExample example);

    int deleteByExample(CompanyPromotionExample example);

    int deleteByPrimaryKey(Integer promotion_id);

    int insert(CompanyPromotion record);

    int insertSelective(CompanyPromotion record);

    List<CompanyPromotion> selectByExample(CompanyPromotionExample example);

    CompanyPromotion selectByPrimaryKey(Integer promotion_id);

    int updateByExampleSelective(@Param("record") CompanyPromotion record, @Param("example") CompanyPromotionExample example);

    int updateByExample(@Param("record") CompanyPromotion record, @Param("example") CompanyPromotionExample example);

    int updateByPrimaryKeySelective(CompanyPromotion record);

    int updateByPrimaryKey(CompanyPromotion record);
}