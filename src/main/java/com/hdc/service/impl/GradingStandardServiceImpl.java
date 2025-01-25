package com.hdc.service.impl;


import com.hdc.dao.GradingStandardDao;
import com.hdc.entity.GradingStandard;
import com.hdc.entity.GradingStandardExample;
import com.hdc.service.GradingStandardService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GradingStandardServiceImpl implements GradingStandardService {

	@Autowired
	private GradingStandardDao gradingStandardDao;

	@Override
	public long countByExample(GradingStandardExample example) {
		return gradingStandardDao.countByExample(example);
	}

	@Override
	public int deleteByExample(GradingStandardExample example) {
		return gradingStandardDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer gradingStandardId) {
		return gradingStandardDao.deleteByPrimaryKey(gradingStandardId);
	}

	@Override
	public int insert(GradingStandard record) {
		return gradingStandardDao.insert(record);
	}

	@Override
	public int insertSelective(GradingStandard record) {
		return gradingStandardDao.insertSelective(record);
	}

	@Override
	public List<GradingStandard> selectByExample(GradingStandardExample example) {
		return gradingStandardDao.selectByExample(example);
	}

	@Override
	public GradingStandard selectByPrimaryKey(Integer gradingStandardId) {
		return gradingStandardDao.selectByPrimaryKey(gradingStandardId);
	}

	@Override
	public int updateByExampleSelective(GradingStandard record, GradingStandardExample example) {
		return gradingStandardDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(GradingStandard record, GradingStandardExample example) {
		return gradingStandardDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(GradingStandard record) {
		return gradingStandardDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GradingStandard record) {
		return gradingStandardDao.updateByPrimaryKey(record);
	}

	@Override
	@Transactional
	public int batchInsertGradingStandard(List<GradingStandard> gradingStandardList) {
		String content,grading_basis,note;
		Integer evaluationIndexId,observationPointId,auditId;
		int i = 0;

		for (GradingStandard gradingStandard : gradingStandardList) {
			i++;
			content = gradingStandard.getContent();
			evaluationIndexId = gradingStandard.getEvaluationIndexId();
			observationPointId = gradingStandard.getObservationPointId();
			auditId = gradingStandard.getAuditId();
			grading_basis = gradingStandard.getGradingBasis();
			note = gradingStandard.getNote();

			if (!StringUtils.isNotBlank(content)) {
				throw new RuntimeException("第" + i + "行评估指标内容数据为空，请检查后重试！");
			}

			if (!StringUtils.isNotBlank(grading_basis)) {
				throw new RuntimeException("第" + i + "行评分依据为空，请检查后重试！");
			}


			if (evaluationIndexId == null || evaluationIndexId<=0) {
				throw new RuntimeException("第" + i + "行评估指标错误，请检查后重试！");
			}

			if (observationPointId == null || observationPointId<=0) {
				throw new RuntimeException("第" + i + "行主要观测点错误，请检查后重试！");
			}

			if (auditId == null || auditId<=0) {
				throw new RuntimeException("第" + i + "行审核机构错误，请检查后重试！");
			}

			try {
				insert(gradingStandard);
			} catch (Exception e) {
				throw new RuntimeException("第" + i + "行数据有误，请检查是否有重复！");
			}

		}
		return 1;
	}
}
