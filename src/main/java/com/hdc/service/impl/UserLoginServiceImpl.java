package com.hdc.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hdc.dao.UserLoginDao;
import com.hdc.entity.UserLoginEntity;
import com.hdc.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserLoginDao userLoginDao;
	
	
	@Override
	public UserLoginEntity getUserLoginByUsername(String username) {
		return userLoginDao.queryUserLoginByUsername(username);
	}

	@Override
	public UserLoginEntity getUserLoginByUserId(Integer userId) {
		return userLoginDao.queryUserLoginByUserId(userId);
	}
}
