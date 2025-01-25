package com.hdc.dao;

import com.hdc.entity.GradingStandard;
import com.hdc.entity.GradingStandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradingStandardDao {
    long countByExample(GradingStandardExample example);

    int deleteByExample(GradingStandardExample example);

    int deleteByPrimaryKey(Integer gradingStandardId);

    int insert(GradingStandard record);

    int insertSelective(GradingStandard record);

    List<GradingStandard> selectByExample(GradingStandardExample example);

    GradingStandard selectByPrimaryKey(Integer gradingStandardId);

    int updateByExampleSelective(@Param("record") GradingStandard record, @Param("example") GradingStandardExample example);

    int updateByExample(@Param("record") GradingStandard record, @Param("example") GradingStandardExample example);

    int updateByPrimaryKeySelective(GradingStandard record);

    int updateByPrimaryKey(GradingStandard record);
}