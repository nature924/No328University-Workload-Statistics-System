package com.hdc.dao;

import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherTitleDao {
    long countByExample(TeacherTitleExample example);

    int deleteByExample(TeacherTitleExample example);

    int deleteByPrimaryKey(Integer teacherTitleId);

    int insert(TeacherTitle record);

    int insertSelective(TeacherTitle record);

    List<TeacherTitle> selectByExample(TeacherTitleExample example);

    TeacherTitle selectByPrimaryKey(Integer teacherTitleId);

    int updateByExampleSelective(@Param("record") TeacherTitle record, @Param("example") TeacherTitleExample example);

    int updateByExample(@Param("record") TeacherTitle record, @Param("example") TeacherTitleExample example);

    int updateByPrimaryKeySelective(TeacherTitle record);

    int updateByPrimaryKey(TeacherTitle record);
}