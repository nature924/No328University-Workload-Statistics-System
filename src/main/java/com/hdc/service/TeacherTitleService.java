package com.hdc.service;


import com.hdc.entity.TeacherTitle;
import com.hdc.entity.TeacherTitleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherTitleService {

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
