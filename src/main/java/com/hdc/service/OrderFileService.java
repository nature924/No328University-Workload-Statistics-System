package com.hdc.service;

import com.hdc.entity.Order;
import com.hdc.entity.OrderExample;
import com.hdc.entity.OrderFile;
import com.hdc.entity.OrderFileExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderFileService {

	long countByExample(OrderFileExample example);

	int deleteByExample(OrderFileExample example);

	int deleteByPrimaryKey(Long orderFileId);

	int insert(OrderFile record);

	int insertSelective(OrderFile record);

	List<OrderFile> selectByExample(OrderFileExample example);

	OrderFile selectByPrimaryKey(Long orderFileId);

	OrderFile selectByOrderId(Long orderId);

	int updateByExampleSelective(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

	int updateByExample(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

	int updateByPrimaryKeySelective(OrderFile record);

	int updateByPrimaryKey(OrderFile record);
}
