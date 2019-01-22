package com.dao.system;

import java.util.List;

import com.model.system.Kbm;

public interface KbmMapper {
    int deleteByPrimaryKey(int kbmId);

    int insert(Kbm record);

    int insertSelective(Kbm record);

    Kbm selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(int kbmId);
    
    List<Kbm> queryAllKbm();

	int updateByPrimaryKeySelective(Kbm kbm);

	int deleteByPrimaryKey1(String kbmId);


}