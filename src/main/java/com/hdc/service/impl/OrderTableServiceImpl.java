package com.hdc.service.impl;

import com.hdc.dao.DeclarationTableDao;
import com.hdc.dao.OrderTableDao;
import com.hdc.entity.DeclarationTable;
import com.hdc.entity.DeclarationTableExample;
import com.hdc.entity.OrderTable;
import com.hdc.entity.OrderTableExample;
import com.hdc.service.DeclarationTableService;
import com.hdc.service.OrderTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderTableServiceImpl implements OrderTableService {

	@Autowired
	private OrderTableDao orderTableDao;


	@Override
	public long countByExample(OrderTableExample example) {
		return orderTableDao.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderTableExample example) {
		return orderTableDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer gradingStandardId) {
		return orderTableDao.deleteByPrimaryKey(gradingStandardId);
	}

	@Override
	public int insert(OrderTable record) {
		return orderTableDao.insert(record);
	}

	@Override
	public int insertSelective(OrderTable record) {
		return orderTableDao.insertSelective(record);
	}

	@Override
	public List<OrderTable> selectByExample(OrderTableExample example) {
		return orderTableDao.selectByExample(example);
	}

	@Override
	public OrderTable selectByPrimaryKey(Integer gradingStandardId) {
		return orderTableDao.selectByPrimaryKey(gradingStandardId);
	}

	@Override
	public int updateByExampleSelective(OrderTable record, OrderTableExample example) {
		return orderTableDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(OrderTable record, OrderTableExample example) {
		return orderTableDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderTable record) {
		return orderTableDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderTable record) {
		return orderTableDao.updateByPrimaryKey(record);
	}

	@Override
	public long countOrderByExample(OrderTableExample example) {
		return orderTableDao.countOrderByExample(example);
	}

	@Override
	public List<OrderTable> selectOrderByExample(OrderTableExample example) {
		return orderTableDao.selectOrderByExample(example);
	}
}
