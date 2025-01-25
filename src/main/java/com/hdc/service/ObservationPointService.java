package com.hdc.service;


import com.hdc.entity.ObservationPoint;
import com.hdc.entity.ObservationPointExample;
import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ObservationPointService {

	long countByExample(ObservationPointExample example);

	int deleteByExample(ObservationPointExample example);

	int deleteByPrimaryKey(Integer observationPointId);

	int insert(ObservationPoint record);

	int insertSelective(ObservationPoint record);

	List<ObservationPoint> selectByExample(ObservationPointExample example);

	ObservationPoint selectByPrimaryKey(Integer observationPointId);

	int updateByExampleSelective(@Param("record") ObservationPoint record, @Param("example") ObservationPointExample example);

	int updateByExample(@Param("record") ObservationPoint record, @Param("example") ObservationPointExample example);

	int updateByPrimaryKeySelective(ObservationPoint record);

	int updateByPrimaryKey(ObservationPoint record);

    int batchInsertObservationPoint(List<ObservationPoint> observationPointList);
}
