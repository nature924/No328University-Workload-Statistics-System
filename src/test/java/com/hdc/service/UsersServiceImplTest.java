package com.hdc.service;

import com.hdc.BaseTest;
import com.hdc.entity.UserInfo;
import com.hdc.entity.Users;
import com.hdc.service.UsersService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import static org.junit.Assert.assertEquals;

public class UsersServiceImplTest extends BaseTest{

	@Autowired
	private UsersService  usersService;



	@Test
	public void testInsertAdmin(){
		Users users = new Users();
		UserInfo userInfo = new UserInfo();
		users.setUsername("mirage");
		users.setEnable((byte) 1);
		users.setState((byte) 1);
		users.setType((byte) 1);
		users.setPassword("mirage");
		userInfo.setDisplayName("mirage");
		userInfo.setEmail("90");
		userInfo.setImgUrl("12");
		userInfo.setPhone("123123");
		int userId = usersService.insertAdmin(users, userInfo);
		assertEquals(6,userId);
	}
	
}
