package com.hdc.dao;

import com.hdc.entity.Authorities;
import com.hdc.entity.AuthoritiesEntity;
import com.hdc.entity.AuthoritiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthoritiesDao {

    List<AuthoritiesEntity> queryAuthorities();

    long countByExample(AuthoritiesExample example);

    int deleteByExample(AuthoritiesExample example);

    int deleteByPrimaryKey(Long authorityId);

    int insert(Authorities record);

    int insertSelective(Authorities record);

    List<Authorities> selectByExample(AuthoritiesExample example);

    Authorities selectByPrimaryKey(Long authorityId);

    int updateByExampleSelective(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);

    int updateByExample(@Param("record") Authorities record, @Param("example") AuthoritiesExample example);

    int updateByPrimaryKeySelective(Authorities record);

    int updateByPrimaryKey(Authorities record);
}