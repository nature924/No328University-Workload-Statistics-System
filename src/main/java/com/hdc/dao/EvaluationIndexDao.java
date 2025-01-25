package com.hdc.dao;

import com.hdc.entity.EvaluationIndex;
import com.hdc.entity.EvaluationIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluationIndexDao {
    long countByExample(EvaluationIndexExample example);

    int deleteByExample(EvaluationIndexExample example);

    int deleteByPrimaryKey(Integer evaluationIndexId);

    int insert(EvaluationIndex record);

    int insertSelective(EvaluationIndex record);

    List<EvaluationIndex> selectByExample(EvaluationIndexExample example);

    EvaluationIndex selectByPrimaryKey(Integer evaluationIndexId);

    int updateByExampleSelective(@Param("record") EvaluationIndex record, @Param("example") EvaluationIndexExample example);

    int updateByExample(@Param("record") EvaluationIndex record, @Param("example") EvaluationIndexExample example);

    int updateByPrimaryKeySelective(EvaluationIndex record);

    int updateByPrimaryKey(EvaluationIndex record);
}