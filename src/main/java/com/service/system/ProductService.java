package com.service.system;

import java.util.List;

import com.model.system.Product;

import framework.utils.pageUtil.PagedResult;

public interface ProductService {

	PagedResult<Product> getAllProductByPage(Integer pageNumber, Integer pageSize);

	int addProduct(Product product);

	int deleteProductById(String productId);

	Product queryProductById(String productId);

	int updateProductByProduct(Product product);

	List<Product> selectAllProduct();

	List<Product> queryAllProduct();


}
