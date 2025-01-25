package com.hdc.dao;

import com.hdc.entity.DeclarationTable;
import com.hdc.entity.DeclarationTableExample;
import java.util.List;

public interface DeclarationTableDao {

    List<DeclarationTable> selectByExample(DeclarationTableExample example);

}