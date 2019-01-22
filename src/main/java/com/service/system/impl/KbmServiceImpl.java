package com.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.github.pagehelper.PageHelper;
import com.model.system.Kbm;

import com.service.system.KbmService;

import framework.controller.BaseController;
import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
@Service
public class KbmServiceImpl extends BaseController implements KbmService {


	private static final long serialVersionUID = 2447528532623393923L;

	@Override
	public PagedResult<Kbm> getAllKbmByPage(Integer pageNumber, Integer pageSize) {
				PageHelper.startPage(pageNumber, pageSize);
				List<Kbm> kbmlist = kbmMapper.queryAllKbm();
				return PageBeanUtil.toPagedResult(kbmlist);
	}

	@Override
	public int addKbm(Kbm kbm) {
	return kbmMapper.insertSelective(kbm);
	}

	@Override
	public int deleteKbmrById(int kbmId) {
		return kbmMapper.deleteByPrimaryKey(kbmId);
	}

	@Override
	public Kbm queryKbmById(int kbmId) {
		return kbmMapper.selectByPrimaryKey(kbmId);
	}

	@Override
	public int updateKbmByKbm(Kbm kbm) {
		System.err.println(kbm+"-----//123///");
		return kbmMapper.updateByPrimaryKeySelective(kbm);
	}

	@Override
	public int deleteKbmrById(String kbmId) {
		return kbmMapper.deleteByPrimaryKey1(kbmId);
	}

	
}
