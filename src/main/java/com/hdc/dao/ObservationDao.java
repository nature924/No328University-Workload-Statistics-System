package com.hdc.dao;

import com.hdc.entity.ObservationPoint;
import com.hdc.entity.ObservationPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObservationDao {
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
}