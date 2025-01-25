package com.hdc.security;

import com.hdc.entity.UserLoginEntity;
import com.hdc.service.impl.UserLoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等
 * 
 */
@Component
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserLoginServiceImpl userLoginServiceImpl;
	@Autowired
	private PasswordEncoder passwordEncoder;
	// @Resource
	// private UserService userService;

	/**
	 * 数据库交互获取用户拥有的权限角色，并设置权限
	 */
	@Override
	public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException, DataAccessException {
		// 根据登录用户名获取用户信息
		// Users user = new Users();
		// user.setUserCode(username);
		// user = userService.selectByModel(user);
		// if (null != user) {
		// 存放权限
		UserLoginEntity userLogin = userLoginServiceImpl.getUserLoginByUsername(userCode);
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		Integer userId = userLogin.getUserId();
		String authorities = userLogin.getAuthorities();
		String username = userLogin.getUsername();
		String password = userLogin.getPassword();
		
		String[] roleaCtion = authorities.split(",");
		for (int i = 0; i < roleaCtion.length; i++) {
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(roleaCtion[i]);
			auths.add(auth);
		}

		// spring security自带的User对象

		MyUser userDetails = new MyUser(username, password, true, true, true, true, auths);
		userDetails.setMyUserId(userId);
		//System.out.println(((MyUser) userDetails).getMyUserId());
		return userDetails;
	}
}