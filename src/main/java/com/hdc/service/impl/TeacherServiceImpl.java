package com.hdc.service.impl;

import com.hdc.dao.*;
import com.hdc.entity.*;
import com.hdc.service.TeacherService;
import com.hdc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeacherTableDao teacherTableDao;

	@Override
	public long countByExample(TeacherExample example) {
		return teacherDao.countByExample(example);
	}

	@Override
	public long tableCountByExample(TeacherTableExample example) {
		return teacherTableDao.countByExample(example);
	}

	@Override
	public int deleteByExample(TeacherExample example) {
		return teacherDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer teacherId) {
		return teacherDao.deleteByPrimaryKey(teacherId);
	}

	@Override
	public int insert(Teacher record) {
		return teacherDao.insert(record);
	}

	@Override
	public int insertSelective(Teacher record) {
		return teacherDao.insertSelective(record);
	}

	@Override
	public List<Teacher> selectByExample(TeacherExample example) {
		return teacherDao.selectByExample(example);
	}

	@Override
	public Teacher selectByPrimaryKey(Integer teacherId) {
		return teacherDao.selectByPrimaryKey(teacherId);
	}

	@Override
	public List<TeacherTable> selectAllByExample(TeacherTableExample example) {
		return teacherTableDao.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Teacher record, TeacherExample example) {
		return teacherDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Teacher record, TeacherExample example) {
		return teacherDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Teacher record) {
		return teacherDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Teacher record) {
		return teacherDao.updateByPrimaryKey(record);
	}
}
