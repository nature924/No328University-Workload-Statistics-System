package com.hdc.service;

import com.hdc.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeclarationTableService {


	List<DeclarationTable> selectByExample(DeclarationTableExample example);

}
