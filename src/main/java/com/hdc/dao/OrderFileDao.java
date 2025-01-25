package com.hdc.dao;

import com.hdc.entity.OrderFile;
import com.hdc.entity.OrderFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFileDao {
    long countByExample(OrderFileExample example);

    int deleteByExample(OrderFileExample example);

    int deleteByPrimaryKey(Long orderFileId);

    int insert(OrderFile record);

    int insertSelective(OrderFile record);

    List<OrderFile> selectByExample(OrderFileExample example);

    OrderFile selectByPrimaryKey(Long orderFileId);

    int updateByExampleSelective(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

    int updateByExample(@Param("record") OrderFile record, @Param("example") OrderFileExample example);

    int updateByPrimaryKeySelective(OrderFile record);

    int updateByPrimaryKey(OrderFile record);

    OrderFile selectByOrderId(Long orderId);
}