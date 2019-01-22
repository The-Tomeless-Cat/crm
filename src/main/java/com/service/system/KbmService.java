package com.service.system;

import com.model.system.Kbm;

import framework.utils.pageUtil.PagedResult;

public interface KbmService {

 PagedResult<Kbm> getAllKbmByPage(Integer pageNumber, Integer pageSize);

int addKbm(Kbm kbm);

int deleteKbmrById(int kbmId);

Kbm queryKbmById(int kbmId);

int updateKbmByKbm(Kbm kbm);

int deleteKbmrById(String kbmId);



	
}
