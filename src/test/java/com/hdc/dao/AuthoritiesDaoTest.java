package com.hdc.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdc.BaseTest;
import com.hdc.dao.AuthoritiesDao;
import com.hdc.entity.AuthoritiesEntity;

public class AuthoritiesDaoTest extends BaseTest {
	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Test
	public void testAuthoritiesDao(){
		List<AuthoritiesEntity> AuthoritiesList = authoritiesDao.queryAuthorities();
		assertEquals(4,AuthoritiesList.size());
	}
}
