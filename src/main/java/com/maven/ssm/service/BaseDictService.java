package com.maven.ssm.service;

import java.util.List;

import com.maven.ssm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> getBaseDictById(String id);
	
	public List<BaseDict> getBaseDictByTypeCode(String code);
}
