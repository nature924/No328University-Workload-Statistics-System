package com.hdc.service.impl;

import com.hdc.dao.DeclarationTableDao;
import com.hdc.dao.TeacherDao;
import com.hdc.dao.TeacherTableDao;
import com.hdc.entity.*;
import com.hdc.service.DeclarationTableService;
import com.hdc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationTableServiceImpl implements DeclarationTableService {

@Autowired
private DeclarationTableDao declarationTableDao;
	@Override
	public List<DeclarationTable> selectByExample(DeclarationTableExample example) {
		return declarationTableDao.selectByExample(example);
	}

}
