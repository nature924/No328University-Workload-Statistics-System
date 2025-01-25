package com.hdc.service;


import com.hdc.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuditService {

	long countByExample(AuditExample example);

	long tableCountByExample(AuditTableExample example);

	int deleteByExample(AuditExample example);

	int deleteByPrimaryKey(Integer auditId);

	int insert(Audit record);

	int insertSelective(Audit record);

	List<Audit> selectByExample(AuditExample example);

    List<AuditTable> selectAllByExample(AuditTableExample example);

    Audit selectByPrimaryKey(Integer auditId);

	int updateByExampleSelective(@Param("record") Audit record, @Param("example") AuditExample example);

	int updateByExample(@Param("record") Audit record, @Param("example") AuditExample example);

	int updateByPrimaryKeySelective(Audit record);

	int updateByPrimaryKey(Audit record);
}
