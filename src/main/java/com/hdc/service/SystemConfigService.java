package com.hdc.service;

import com.hdc.dto.SystemBaseConfigDto;
import com.hdc.entity.SystemBaseConfig;
import com.hdc.entity.SystemConfig;
import com.hdc.entity.SystemConfigExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SystemConfigService {
	long countByExample(SystemConfigExample example);

	int deleteByExample(SystemConfigExample example);

	int deleteByPrimaryKey(Integer systemConfigId);

	int insert(SystemConfig record);

	int insertSelective(SystemConfig record);

	List<SystemConfig> selectByExample(SystemConfigExample example);

	SystemConfig selectByPrimaryKey(Integer systemConfigId);

	int updateByExampleSelective(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

	int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

	int updateByPrimaryKeySelective(SystemConfig record);

	int updateByPrimaryKey(SystemConfig record);

	SystemBaseConfig getSystemBaseConfig();

	void updateBySystemBaseConfigDto(SystemBaseConfigDto systemBaseConfigDto);
}
