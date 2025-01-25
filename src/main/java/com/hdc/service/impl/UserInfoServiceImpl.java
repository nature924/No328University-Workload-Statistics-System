package com.hdc.service.impl;

import com.hdc.dao.AuthoritiesDao;
import com.hdc.dao.UserInfoDao;
import com.hdc.entity.*;
import com.hdc.service.AuthoritiesService;
import com.hdc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;


	@Override
	public long countByExample(UserInfoExample example) {
		return userInfoDao.countByExample(example);
	}

	@Override
	@Transactional
	public int deleteByExample(UserInfoExample example) {
		return userInfoDao.deleteByExample(example);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer userInfoId) {
		return userInfoDao.deleteByPrimaryKey(userInfoId);
	}

	@Override
	@Transactional
	public int insert(UserInfo record) {
		return userInfoDao.insert(record);
	}

	@Override
	@Transactional
	public int insertSelective(UserInfo record) {
		return userInfoDao.insertSelective(record);
	}

	@Override
	public List<UserInfo> selectByExample(UserInfoExample example) {
		return userInfoDao.selectByExample(example);
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer userInfoId) {
		return userInfoDao.selectByPrimaryKey(userInfoId);
	}

	@Override
	@Transactional
	public int updateByExampleSelective(UserInfo record, UserInfoExample example) {
		return userInfoDao.updateByExampleSelective(record, example);
	}

	@Override
	@Transactional
	public int updateByExample(UserInfo record, UserInfoExample example) {
		return userInfoDao.updateByExample(record, example);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(UserInfo record) {
		return userInfoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(UserInfo record) {
		return userInfoDao.updateByPrimaryKey(record);
	}
}
