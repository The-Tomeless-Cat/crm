package com.service.system;

import java.util.List;

import com.model.system.ProductCollect;

import framework.utils.pageUtil.PagedResult;

public interface ProductCollectService {

	PagedResult<ProductCollect> getAllProductCollectByPage(Integer pageNumber, Integer pageSize);

	List<ProductCollect> queryAllproduct();

	int addproductCollect(ProductCollect productCollect);

	int deleteProductById(String productMsgId);

	ProductCollect queryProductById(String productMsgId);

	int updateProductCollectByProduct(ProductCollect productCollect);

	PagedResult<ProductCollect> likeQuery(String name);

}
