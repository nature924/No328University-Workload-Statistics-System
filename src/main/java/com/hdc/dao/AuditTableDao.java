package com.hdc.dao;

import com.hdc.entity.AuditTable;
import com.hdc.entity.AuditTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuditTableDao {
    long countByExample(AuditTableExample example);

    int deleteByExample(AuditTableExample example);

    int deleteByPrimaryKey(Integer auditId);

    int insert(AuditTable record);

    int insertSelective(AuditTable record);

    List<AuditTable> selectByExample(AuditTableExample example);

    AuditTable selectByPrimaryKey(Integer auditId);

    int updateByExampleSelective(@Param("record") AuditTable record, @Param("example") AuditTableExample example);

    int updateByExample(@Param("record") AuditTable record, @Param("example") AuditTableExample example);

    int updateByPrimaryKeySelective(AuditTable record);

    int updateByPrimaryKey(AuditTable record);
}