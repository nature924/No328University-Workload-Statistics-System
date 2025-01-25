package com.hdc.service.impl;

import com.hdc.dao.AdminDao;
import com.hdc.dao.AuthoritiesDao;
import com.hdc.dao.UserInfoDao;
import com.hdc.dao.UsersDao;
import com.hdc.entity.*;
import com.hdc.service.AdminService;
import com.hdc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;


	@Override
	public long countByExample(AdminExample example) {
		return adminDao.countByExample(example);
	}

	@Override
	public int deleteByExample(AdminExample example) {
		return adminDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer adminId) {
		return adminDao.deleteByPrimaryKey(adminId);
	}

	@Override
	public int insert(Admin record) {
		return adminDao.insert(record);
	}

	@Override
	public int insertSelective(Admin record) {
		return adminDao.insertSelective(record);
	}

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		return adminDao.selectByExample(example);
	}

	@Override
	public Admin selectByPrimaryKey(Integer adminId) {
		return adminDao.selectByPrimaryKey(adminId);
	}

	@Override
	public int updateByExampleSelective(Admin record, AdminExample example) {
		return adminDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Admin record, AdminExample example) {
		return adminDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {
		return adminDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		return adminDao.updateByPrimaryKey(record);
	}
}
