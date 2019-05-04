package com.maven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.ssm.mapper.BaseDictMapper;
import com.maven.ssm.pojo.BaseDict;
import com.maven.ssm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> getBaseDictById(String id) {
		return baseDictMapper.getBaseDictById(id);
	}

	@Override
	public List<BaseDict> getBaseDictByTypeCode(String code) {
		return baseDictMapper.getBaseDictByTypeCode(code);
	}

}
