package com.dao.system;

import java.util.List;

import com.model.system.ProductCollect;

public interface ProductCollectMapper {

	int deleteByPrimaryKey(String productMsgId);

    int insert(ProductCollect record);

    int insertSelective(ProductCollect record);

    ProductCollect selectByPrimaryKey(String productMsgId);

    int updateByPrimaryKeySelective(ProductCollect record);

    int updateByPrimaryKey(ProductCollect record);

	List<ProductCollect> selectAllproductCollect();

	List<ProductCollect> likeQuery(String name);
	
}