package com.hdc.dao;

import java.util.List;

import com.hdc.entity.AuthoritiesEntity;
import com.hdc.entity.UserLoginEntity;

public interface UserLoginDao {
	/**
	 * 通过用户名查询用户登陆所需信息
	 * @return
	 */
	UserLoginEntity queryUserLoginByUsername(String username);

	UserLoginEntity queryUserLoginByUserId(Integer userId);
	
}
