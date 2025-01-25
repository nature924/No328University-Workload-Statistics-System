package com.hdc.service;


import com.hdc.entity.GradingStandard;
import com.hdc.entity.GradingStandardExample;
import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradingStandardService {

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

	int batchInsertGradingStandard(List<GradingStandard> gradingStandardList);
}
