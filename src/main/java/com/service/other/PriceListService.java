package com.service.other;

import com.model.other.PriceList;

import framework.utils.pageUtil.PagedResult;

public interface PriceListService {

	PagedResult<PriceList> getAllPriceListByPage(Integer pageNumber, Integer pageSize);

	int deletePricelist(String priceListId);

	int addPricelist(PriceList priceList);

	PriceList selectPriceListIdByPriceListId(String priceListId);

	int updateBypriceList(PriceList priceList);

	int deletePriceListByPriceListId(String pricelistId);

}
