package com.hdc.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdc.BaseTest;
import com.hdc.entity.AuthoritiesEntity;
import com.hdc.service.AuthoritiesService;

public class AuthoritiesServiceImplTest extends BaseTest{
	@Autowired
	private AuthoritiesService authoritiesService;
	
	@Test
	public void testAuthoritiesServiceImpl(){
		List<AuthoritiesEntity> AuthoritiesList = authoritiesService.getAuthoritiesList();
		assertEquals(4,AuthoritiesList.size());
	}
	
}
