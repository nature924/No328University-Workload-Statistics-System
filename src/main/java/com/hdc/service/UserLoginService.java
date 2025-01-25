package com.hdc.service;

import java.util.List;

import com.hdc.entity.AuthoritiesEntity;
import com.hdc.entity.UserLoginEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserLoginService {
	/**
	 *	获取登录时用户所需信息
	 * @return
	 */
	UserLoginEntity getUserLoginByUsername(String username);

	UserLoginEntity getUserLoginByUserId(Integer userId);
}
