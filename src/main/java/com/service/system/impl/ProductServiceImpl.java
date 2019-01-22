package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Product;
import com.service.system.ProductService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
 
	@Override
	public PagedResult<Product> getAllProductByPage(Integer pageNumber, Integer pageSize) {

		PageHelper.startPage(pageNumber, pageSize);

		List<Product> productlist = productMapper.selectAllProduct();

		return PageBeanUtil.toPagedResult(productlist);
	}

	@Override
	public int addProduct(Product product) {
		
		return productMapper.insertSelective(product);
	}

	@Override
	public int deleteProductById(String productId) {
		
		return productMapper.deleteByPrimaryKey(productId);
	}

	@Override
	public Product queryProductById(String productId) {
		
		return productMapper.selectByPrimaryKey(productId);
	}

	@Override
	public int updateProductByProduct(Product product) {
		
		return productMapper.updateByPrimaryKeySelective(product);
	}

	@Override
	public List<Product> queryAllProduct() {
		
		return productMapper.selectAllProduct();
	}


	@Override
	public List<Product> selectAllProduct() {
		// TODO Auto-generated method stub
		return productMapper.selectAllProduct();
	}




	
}
