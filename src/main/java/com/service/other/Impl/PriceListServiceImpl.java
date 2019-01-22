package com.service.other.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.other.PriceListMapper;
import com.github.pagehelper.PageHelper;
import com.model.other.PriceList;
import com.service.other.PriceListService;

import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class PriceListServiceImpl implements PriceListService{
	@Autowired
	private PriceListMapper priceListMapper;
	
	@Override
	public PagedResult<PriceList> getAllPriceListByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		// 2.查询数据库，获取数据
		List<PriceList> activitylist = priceListMapper.selectPriceList();
		// 3.通过分页工具类加载分页数据
		return PageBeanUtil.toPagedResult(activitylist);
	}

	@Override
	public int deletePricelist(String priceListId) {
		// TODO Auto-generated method stub
		return priceListMapper.deleteByPrimaryKey(priceListId);
	}

	@Override
	public int addPricelist(PriceList priceList) {
		// TODO Auto-generated method stub
		return priceListMapper.insertSelective(priceList);
	}

	@Override
	public PriceList selectPriceListIdByPriceListId(String priceListId) {
		// TODO Auto-generated method stub
		return priceListMapper.selectByPrimaryKey(priceListId);
	}

	@Override
	public int updateBypriceList(PriceList priceList) {
		// TODO Auto-generated method stub
		return priceListMapper.updateByPrimaryKeySelective(priceList);
	}

	@Override
	public int deletePriceListByPriceListId(String pricelistId) {
		// TODO Auto-generated method stub
		return priceListMapper.deleteByPrimaryKey(pricelistId);
	}

}
