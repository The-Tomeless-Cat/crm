package com.dao.system;

import java.util.List;

import com.model.system.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product product);

    int updateByPrimaryKey(Product record);

	List<Product> selectAllProduct();
}