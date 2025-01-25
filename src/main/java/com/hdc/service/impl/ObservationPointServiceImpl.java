package com.hdc.service.impl;


import com.hdc.dao.ObservationPointDao;
import com.hdc.entity.ObservationPoint;
import com.hdc.entity.ObservationPointExample;
import com.hdc.service.ObservationPointService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObservationPointServiceImpl implements ObservationPointService {

	@Autowired
	private ObservationPointDao observationPointDao;

	@Override
	public long countByExample(ObservationPointExample example) {
		return observationPointDao.countByExample(example);
	}

	@Override
	@Transactional
	public int deleteByExample(ObservationPointExample example) {
		return observationPointDao.deleteByExample(example);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer observationPointId) {
		return observationPointDao.deleteByPrimaryKey(observationPointId);
	}

	@Override
	@Transactional
	public int insert(ObservationPoint record) {
		return observationPointDao.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(ObservationPoint record) {
		return observationPointDao.insertSelective(record);
	}

	@Override
	public List<ObservationPoint> selectByExample(ObservationPointExample example) {
		return observationPointDao.selectByExample(example);
	}

	@Override
	public ObservationPoint selectByPrimaryKey(Integer observationPointId) {
		return observationPointDao.selectByPrimaryKey(observationPointId);
	}

	@Override
	@Transactional
	public int updateByExampleSelective(ObservationPoint record, ObservationPointExample example) {
		return observationPointDao.updateByExampleSelective(record, example);
	}

	@Override
	@Transactional
	public int updateByExample(ObservationPoint record, ObservationPointExample example) {
		return observationPointDao.updateByExample(record, example);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(ObservationPoint record) {
		return observationPointDao.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(ObservationPoint record) {
		return observationPointDao.updateByPrimaryKey(record);
	}


	@Override
	@Transactional
	public int batchInsertObservationPoint(List<ObservationPoint> observationPointList) {
		String content;
		Integer evaluationIndexId;
		int i = 0;

		for (ObservationPoint observationPoint : observationPointList) {
			i++;
			content = observationPoint.getContent();
			evaluationIndexId = observationPoint.getEvaluationIndexId();

			if (!StringUtils.isNotBlank(content)) {
				throw new RuntimeException("第" + i + "行评估指标内容数据为空，请检查后重试！");
			}

			if (evaluationIndexId == null || evaluationIndexId<=0) {
				throw new RuntimeException("第" + i + "行评估指标错误，请检查后重试！");
			}

			try {
				insert(observationPoint);
			} catch (Exception e) {
				throw new RuntimeException("第" + i + "行数据有误，请检查是否有重复！");
			}

		}
		return 1;
	}
}
