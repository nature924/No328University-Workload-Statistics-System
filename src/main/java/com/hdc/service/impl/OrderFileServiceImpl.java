package com.hdc.service.impl;

import com.hdc.dao.OrderDao;
import com.hdc.dao.OrderFileDao;
import com.hdc.entity.Order;
import com.hdc.entity.OrderExample;
import com.hdc.entity.OrderFile;
import com.hdc.entity.OrderFileExample;
import com.hdc.service.OrderFileService;
import com.hdc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFileServiceImpl implements OrderFileService {


	@Autowired
	private OrderFileDao orderFileDao;


	@Override
	public long countByExample(OrderFileExample example) {
		return orderFileDao.countByExample(example);
	}

	@Override
	public int deleteByExample(OrderFileExample example) {
		return orderFileDao.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long orderFileId) {
		return orderFileDao.deleteByPrimaryKey(orderFileId);
	}

	@Override
	public int insert(OrderFile record) {
		return orderFileDao.insert(record);
	}

	@Override
	public int insertSelective(OrderFile record) {
		return orderFileDao.insertSelective(record);
	}

	@Override
	public List<OrderFile> selectByExample(OrderFileExample example) {
		return orderFileDao.selectByExample(example);
	}

	@Override
	public OrderFile selectByPrimaryKey(Long orderFileId) {
		return orderFileDao.selectByPrimaryKey(orderFileId);
	}

	@Override
	public OrderFile selectByOrderId(Long orderId) {
		return orderFileDao.selectByOrderId(orderId);
	}

	@Override
	public int updateByExampleSelective(OrderFile record, OrderFileExample example) {
		return orderFileDao.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(OrderFile record, OrderFileExample example) {
		return orderFileDao.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderFile record) {
		return orderFileDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrderFile record) {
		return orderFileDao.updateByPrimaryKey(record);
	}
}
