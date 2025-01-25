package com.hdc.service;

import java.util.List;

import com.hdc.entity.Authorities;
import com.hdc.entity.AuthoritiesEntity;
import com.hdc.entity.AuthoritiesExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface AuthoritiesService {
	List<AuthoritiesEntity> getAuthoritiesList();

	long countByExample(AuthoritiesExample example);

	int deleteByExample(AuthoritiesExample example);

	int deleteByPrimaryKey(Long authorityId);

	int insert(Authorities record);

	int insertSelective(Authorities record);

	List<Authorities> selectByExample(AuthoritiesExample example);

	Authorities selectByPrimaryKey(Long authorityId);

	int updateByExampleSelective(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);

	int updateByExample(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);

	int updateByPrimaryKeySelective(Authorities record);

	int updateByPrimaryKey(Authorities record);
}
