package com.hdc.service;

import com.hdc.entity.DeclarationTable;
import com.hdc.entity.DeclarationTableExample;
import com.hdc.entity.OrderTable;
import com.hdc.entity.OrderTableExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderTableService {
	long countByExample(OrderTableExample example);

	int deleteByExample(OrderTableExample example);

	int deleteByPrimaryKey(Integer gradingStandardId);

	int insert(OrderTable record);

	int insertSelective(OrderTable record);

	List<OrderTable> selectByExample(OrderTableExample example);

	OrderTable selectByPrimaryKey(Integer gradingStandardId);

	int updateByExampleSelective(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

	int updateByExample(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

	int updateByPrimaryKeySelective(OrderTable record);

	int updateByPrimaryKey(OrderTable record);

	long countOrderByExample(OrderTableExample example);

	List<OrderTable> selectOrderByExample(OrderTableExample example);
}

