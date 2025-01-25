package com.hdc.service.impl;

import com.hdc.dao.OrderDao;
import com.hdc.dao.TeacherDao;
import com.hdc.dao.TeacherTableDao;
import com.hdc.entity.*;
import com.hdc.service.OrderService;
import com.hdc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;


	@Override
	public long countByExample(OrderExample example) {
		return orderDao.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderExample example) {
		return orderDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long orderId) {
		return orderDao.deleteByPrimaryKey(orderId);
	}

	@Override
	public int insert(Order record) {
		return orderDao.insert(record);
	}

	@Override
	public int insertSelective(Order record) {
		return orderDao.insertSelective(record);
	}

	@Override
	public List<Order> selectByExample(OrderExample example) {
		return orderDao.selectByExample(example);
	}

	@Override
	public Order selectByPrimaryKey(Long orderId) {
		return orderDao.selectByPrimaryKey(orderId);
	}

	@Override
	public int updateByExampleSelective(Order record, OrderExample example) {
		return orderDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Order record, OrderExample example) {
		return orderDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		return orderDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		return orderDao.updateByPrimaryKey(record);
	}
}
