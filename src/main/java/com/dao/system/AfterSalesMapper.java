package com.dao.system;

import java.util.List;

import com.model.system.AfterSales;

public interface AfterSalesMapper {
    int deleteByPrimaryKey(String afterSalesId);

    int insert(AfterSales record);

    int insertSelective(AfterSales record);

    AfterSales selectByPrimaryKey(String afterSalesId);

    int updateByPrimaryKeySelective(AfterSales record);

    int updateByPrimaryKey(AfterSales record);

	List<AfterSales> queryAfterSalesAll();

}