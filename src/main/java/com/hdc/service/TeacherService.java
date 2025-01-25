package com.hdc.service;

import com.hdc.entity.Teacher;
import com.hdc.entity.TeacherExample;
import com.hdc.entity.TeacherTable;
import com.hdc.entity.TeacherTableExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

	long countByExample(TeacherExample example);

    long tableCountByExample(TeacherTableExample example);

    int deleteByExample(TeacherExample example);

	int deleteByPrimaryKey(Integer teacherId);

	int insert(Teacher record);

	int insertSelective(Teacher record);

	List<Teacher> selectByExample(TeacherExample example);

	Teacher selectByPrimaryKey(Integer teacherId);

    List<TeacherTable> selectAllByExample(TeacherTableExample example);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

	int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

	int updateByPrimaryKeySelective(Teacher record);

	int updateByPrimaryKey(Teacher record);
}
