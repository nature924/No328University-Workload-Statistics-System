package com.hdc.service.impl;

import java.util.List;

import com.hdc.entity.Authorities;
import com.hdc.entity.AuthoritiesExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdc.dao.AuthoritiesDao;
import com.hdc.entity.AuthoritiesEntity;
import com.hdc.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Override
	public List<AuthoritiesEntity> getAuthoritiesList() {
		List<AuthoritiesEntity> AuthoritiesList=authoritiesDao.queryAuthorities();
		return AuthoritiesList;
	}

	@Override
	public long countByExample(AuthoritiesExample example) {
		return authoritiesDao.countByExample(example);
	}

	@Override
	public int deleteByExample(AuthoritiesExample example) {
		return authoritiesDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long authorityId) {
		return authoritiesDao.deleteByPrimaryKey(authorityId);
	}

	@Override
	public int insert(Authorities record) {
		return authoritiesDao.insert(record);
	}

	@Override
	public int insertSelective(Authorities record) {
		return authoritiesDao.insertSelective(record);
	}

	@Override
	public List<Authorities> selectByExample(AuthoritiesExample example) {
		return authoritiesDao.selectByExample(example);
	}

	@Override
	public Authorities selectByPrimaryKey(Long authorityId) {
		return authoritiesDao.selectByPrimaryKey(authorityId);
	}

	@Override
	public int updateByExampleSelective(Authorities record, AuthoritiesExample example) {
		return authoritiesDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Authorities record, AuthoritiesExample example) {
		return authoritiesDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Authorities record) {
		return authoritiesDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Authorities record) {
		return authoritiesDao.updateByPrimaryKey(record);
	}


}
