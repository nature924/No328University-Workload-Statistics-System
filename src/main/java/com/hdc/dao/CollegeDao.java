package com.hdc.dao;

import com.hdc.entity.College;
import com.hdc.entity.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeDao {
    long countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    List<College> selectByExample(CollegeExample example);

    List<College> selectAll();

    College selectByPrimaryKey(Integer collegeId);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);


    List<College> selectAllByExample(CollegeExample example);
}