package com.hdc.dao;

import com.hdc.entity.TeacherTable;
import com.hdc.entity.TeacherTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherTableDao {
    long countByExample(TeacherTableExample example);

    int deleteByExample(TeacherTableExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(TeacherTable record);

    int insertSelective(TeacherTable record);

    List<TeacherTable> selectByExample(TeacherTableExample example);

    TeacherTable selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") TeacherTable record, @Param("example") TeacherTableExample example);

    int updateByExample(@Param("record") TeacherTable record, @Param("example") TeacherTableExample example);

    int updateByPrimaryKeySelective(TeacherTable record);

    int updateByPrimaryKey(TeacherTable record);
}