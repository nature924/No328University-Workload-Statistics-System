package com.hdc.service.impl;

import com.hdc.dao.SystemConfigDao;
import com.hdc.dao.UserInfoDao;
import com.hdc.dto.SystemBaseConfigDto;
import com.hdc.entity.*;
import com.hdc.service.SystemConfigService;
import com.hdc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

	@Autowired
	private SystemConfigDao systemConfigDao;


	@Override
	public long countByExample(SystemConfigExample example) {
		return systemConfigDao.countByExample(example);
	}

	@Override
	@Transactional
	public int deleteByExample(SystemConfigExample example) {
		return systemConfigDao.deleteByExample(example);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(Integer systemConfigId) {
		return systemConfigDao.deleteByPrimaryKey(systemConfigId);
	}

	@Override
	@Transactional
	public int insert(SystemConfig record) {
		return systemConfigDao.insert(record);
	}

	@Override
	public int insertSelective(SystemConfig record) {
		return systemConfigDao.insertSelective(record);
	}

	@Override
	public List<SystemConfig> selectByExample(SystemConfigExample example) {
		return systemConfigDao.selectByExample(example);
	}



	@Override
	public SystemConfig selectByPrimaryKey(Integer systemConfigId) {
		if(systemConfigId == null ||systemConfigId <=0){
			systemConfigId = 1;
		}
		return systemConfigDao.selectByPrimaryKey(systemConfigId);
	}

	@Override
	@Transactional
	public int updateByExampleSelective(SystemConfig record, SystemConfigExample example) {
		return systemConfigDao.updateByExampleSelective(record, example);
	}

	@Override
	@Transactional
	public int updateByExample(SystemConfig record, SystemConfigExample example) {
		return systemConfigDao.updateByExample(record, example);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(SystemConfig record) {
		return systemConfigDao.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	public int updateByPrimaryKey(SystemConfig record) {
		return systemConfigDao.updateByPrimaryKey(record);
	}

	@Override
	public SystemBaseConfig getSystemBaseConfig() {

		SystemBaseConfig systemBaseConfig = new SystemBaseConfig();

		systemBaseConfig.setSystemOpen(Byte.parseByte(systemConfigDao.selectValueByName("open")));
		systemBaseConfig.setSystemYear(Integer.parseInt(systemConfigDao.selectValueByName("year")));
		systemBaseConfig.setSystemSemester(Integer.parseInt(systemConfigDao.selectValueByName("semester")));
		System.out.println(systemBaseConfig.toString());
		return systemBaseConfig;
	}

	@Override
	@Transactional
	public void updateBySystemBaseConfigDto(SystemBaseConfigDto systemBaseConfigDto) {

		SystemConfig systemConfig = new SystemConfig();

		systemConfig.setName("open");
		systemConfig.setValue(String.valueOf(systemBaseConfigDto.getSystemOpen()));
		int effectedCount1 =  systemConfigDao.updateValueByName(systemConfig);

		systemConfig.setName("year");
		systemConfig.setValue(String.valueOf(systemBaseConfigDto.getSystemYear()));
		int effectedCount2 = systemConfigDao.updateValueByName(systemConfig);

		systemConfig.setName("semester");
		systemConfig.setValue(String.valueOf(systemBaseConfigDto.getSystemSemester()));
		int effectedCount3 = systemConfigDao.updateValueByName(systemConfig);

		if (effectedCount1 <= 0 &&effectedCount2 <= 0 &&effectedCount3 <= 0 ) {
			throw new RuntimeException("系统信息更新错误");
		}
	}

}
