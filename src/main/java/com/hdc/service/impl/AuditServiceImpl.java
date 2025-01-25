package com.hdc.service.impl;

import com.hdc.dao.*;
import com.hdc.entity.*;
import com.hdc.service.AuditService;
import com.hdc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	private AuditDao auditDao;

    @Autowired
    private AuditTableDao auditTableDao;

	@Override
	public long countByExample(AuditExample example) {
		return auditDao.countByExample(example);
	}

    @Override
    public long tableCountByExample(AuditTableExample example) {
        return auditTableDao.countByExample(example);
    }

	@Override
	public int deleteByExample(AuditExample example) {
		return auditDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer auditId) {
		return auditDao.deleteByPrimaryKey(auditId);
	}

	@Override
	public int insert(Audit record) {
		return auditDao.insert(record);
	}

	@Override
	public int insertSelective(Audit record) {
		return auditDao.insertSelective(record);
	}

	@Override
	public List<Audit> selectByExample(AuditExample example) {
		return auditDao.selectByExample(example);
	}


    @Override
    public List<AuditTable> selectAllByExample(AuditTableExample example) {
        return auditTableDao.selectByExample(example);
    }

    @Override
	public Audit selectByPrimaryKey(Integer auditId) {
		return auditDao.selectByPrimaryKey(auditId);
	}

	@Override
	public int updateByExampleSelective(Audit record, AuditExample example) {
		return auditDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Audit record, AuditExample example) {
		return auditDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Audit record) {
		return auditDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Audit record) {
		return auditDao.updateByPrimaryKey(record);
	}
}
