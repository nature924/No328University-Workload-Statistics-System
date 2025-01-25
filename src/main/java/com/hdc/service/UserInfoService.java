package com.hdc.service;

import com.hdc.entity.UserInfo;
import com.hdc.entity.UserInfoExample;
import com.hdc.entity.Users;
import com.hdc.entity.UsersExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserInfoService {
	long countByExample(UserInfoExample example);

	int deleteByExample(UserInfoExample example);

	int deleteByPrimaryKey(Integer userInfoId);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	List<UserInfo> selectByExample(UserInfoExample example);

	UserInfo selectByPrimaryKey(Integer userInfoId);

	int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

	int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);
}
