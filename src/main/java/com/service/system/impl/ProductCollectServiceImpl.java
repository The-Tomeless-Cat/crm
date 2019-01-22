package com.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.system.ProductCollectMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.ProductCollect;  
import com.service.system.ProductCollectService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class ProductCollectServiceImpl implements ProductCollectService {
	@Autowired
	private ProductCollectMapper  productCollectMapper;
	@Override
	public PagedResult<ProductCollect> getAllProductCollectByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		
		List<ProductCollect> productCollectlist = productCollectMapper.selectAllproductCollect();
	
		return PageBeanUtil.toPagedResult(productCollectlist);
	}
	@Override
	public List<ProductCollect> queryAllproduct() {
		return productCollectMapper.selectAllproductCollect();
	}
	@Override
	public int addproductCollect(ProductCollect productCollect) {
		return productCollectMapper.insertSelective(productCollect);
	}
	@Override
	public int deleteProductById(String productMsgId) {
		return productCollectMapper.deleteByPrimaryKey(productMsgId);		
		
	}
	@Override
	public ProductCollect queryProductById(String productMsgId) {
		return productCollectMapper.selectByPrimaryKey(productMsgId);
	}
	@Override
	public int updateProductCollectByProduct(ProductCollect productCollect) {
		return productCollectMapper.updateByPrimaryKeySelective(productCollect);
	}
	@Override
	public PagedResult<ProductCollect> likeQuery(String name) {
		List<ProductCollect> productCollectList = productCollectMapper.likeQuery(name);
		return PageBeanUtil.toPagedResult(productCollectList);
	}
	
}
