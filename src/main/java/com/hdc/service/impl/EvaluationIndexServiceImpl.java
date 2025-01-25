package com.hdc.service.impl;


import com.hdc.dao.EvaluationIndexDao;
import com.hdc.entity.EvaluationIndex;
import com.hdc.entity.EvaluationIndexExample;
import com.hdc.service.EvaluationIndexService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationIndexServiceImpl implements EvaluationIndexService {

    @Autowired
    private EvaluationIndexDao evaluationIndexDao;

    @Override
    public long countByExample(EvaluationIndexExample example) {
        return evaluationIndexDao.countByExample(example);
    }

    @Transactional
    @Override
    public int deleteByExample(EvaluationIndexExample example) {
        return evaluationIndexDao.deleteByExample(example);
    }

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer evaluationIndexId) {
        return evaluationIndexDao.deleteByPrimaryKey(evaluationIndexId);
    }

    @Transactional
    @Override
    public int insert(EvaluationIndex record) {
        return evaluationIndexDao.insert(record);
    }

    @Override
    @Transactional
    public int batchInsertEvaluationIndex(List<EvaluationIndex> evaluationIndexrList) {

        String content;
        int i = 0;

        for (EvaluationIndex evaluationIndex : evaluationIndexrList) {
            i++;
            content = evaluationIndex.getContent();

            if (!StringUtils.isNotBlank(content)) {
                throw new RuntimeException("第" + i + "行评估指标内容数据为空，请检查后重试！");
            }
            try {
                insert(evaluationIndex);
            } catch (Exception e) {
                throw new RuntimeException("第" + i + "行数据有误，请检查是否有重复！");
            }

        }
        return 1;
    }

    @Transactional
    @Override
    public int insertSelective(EvaluationIndex record) {
        return evaluationIndexDao.insertSelective(record);
    }

    @Override
    public List<EvaluationIndex> selectByExample(EvaluationIndexExample example) {
        return evaluationIndexDao.selectByExample(example);
    }

    @Override
    public EvaluationIndex selectByPrimaryKey(Integer evaluationIndexId) {
        return evaluationIndexDao.selectByPrimaryKey(evaluationIndexId);
    }

    @Transactional
    @Override
    public int updateByExampleSelective(EvaluationIndex record, EvaluationIndexExample example) {
        return evaluationIndexDao.updateByExampleSelective(record, example);
    }

    @Transactional
    @Override
    public int updateByExample(EvaluationIndex record, EvaluationIndexExample example) {
        return evaluationIndexDao.updateByExample(record, example);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(EvaluationIndex record) {
        return evaluationIndexDao.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(EvaluationIndex record) {
        return evaluationIndexDao.updateByPrimaryKey(record);
    }
}
