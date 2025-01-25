package com.hdc.service.impl;

import com.hdc.dao.AuthoritiesDao;
import com.hdc.dao.TeacherTitleDao;
import com.hdc.dao.UserInfoDao;
import com.hdc.dao.UsersDao;
import com.hdc.entity.*;
import com.hdc.service.TeacherTitleService;
import com.hdc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherTitleServiceImpl implements TeacherTitleService {

	@Autowired
	private TeacherTitleDao teacherTitleDao;


	@Override
	public long countByExample(TeacherTitleExample example) {
		return teacherTitleDao.countByExample(example);
	}

	@Override
	public int deleteByExample(TeacherTitleExample example) {
		return teacherTitleDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer teacherTitleId) {
		return teacherTitleDao.deleteByPrimaryKey(teacherTitleId);
	}

	@Override
	public int insert(TeacherTitle record) {
		return teacherTitleDao.insert(record);
	}

	@Override
	public int insertSelective(TeacherTitle record) {
		return teacherTitleDao.insertSelective(record);
	}

	@Override
	public List<TeacherTitle> selectByExample(TeacherTitleExample example) {
		return teacherTitleDao.selectByExample(example);
	}

	@Override
	public TeacherTitle selectByPrimaryKey(Integer teacherTitleId) {
		return teacherTitleDao.selectByPrimaryKey(teacherTitleId);
	}

	@Override
	public int updateByExampleSelective(TeacherTitle record, TeacherTitleExample example) {
		return teacherTitleDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(TeacherTitle record, TeacherTitleExample example) {
		return teacherTitleDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(TeacherTitle record) {
		return teacherTitleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TeacherTitle record) {
		return teacherTitleDao.updateByPrimaryKey(record);
	}
}
