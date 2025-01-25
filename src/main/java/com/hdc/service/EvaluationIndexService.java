package com.hdc.service;


import com.hdc.entity.EvaluationIndex;
import com.hdc.entity.EvaluationIndexExample;
import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface EvaluationIndexService {

	long countByExample(EvaluationIndexExample example);

	int deleteByExample(EvaluationIndexExample example);

	int deleteByPrimaryKey(Integer evaluationIndexId);

	int insert(EvaluationIndex record);

	@Transactional
	int batchInsertEvaluationIndex(List<EvaluationIndex> evaluationIndexrList);

	int insertSelective(EvaluationIndex record);

	List<EvaluationIndex> selectByExample(EvaluationIndexExample example);

	EvaluationIndex selectByPrimaryKey(Integer evaluationIndexId);

	int updateByExampleSelective(@Param("record") EvaluationIndex record, @Param("example") EvaluationIndexExample example);

	int updateByExample(@Param("record") EvaluationIndex record, @Param("example") EvaluationIndexExample example);

	int updateByPrimaryKeySelective(EvaluationIndex record);

	int updateByPrimaryKey(EvaluationIndex record);
}
