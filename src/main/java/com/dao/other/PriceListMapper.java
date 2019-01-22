package com.dao.other;

import java.util.List;

import com.model.other.PriceList;

public interface PriceListMapper {
    int deleteByPrimaryKey(String priceListId);

    int insert(PriceList record);

    int insertSelective(PriceList record);

    PriceList selectByPrimaryKey(String priceListId);

    int updateByPrimaryKeySelective(PriceList record);

    int updateByPrimaryKey(PriceList record);

	List<PriceList> selectPriceList();
}