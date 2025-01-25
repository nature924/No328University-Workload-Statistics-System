package com.hdc.service;


import com.hdc.entity.Admin;
import com.hdc.entity.AdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

	long countByExample(AdminExample example);

	int deleteByExample(AdminExample example);

	int deleteByPrimaryKey(Integer adminId);

	int insert(Admin record);

	int insertSelective(Admin record);

	List<Admin> selectByExample(AdminExample example);

	Admin selectByPrimaryKey(Integer adminId);

	int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

	int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);
}
