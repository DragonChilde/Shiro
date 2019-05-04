package com.maven.ssm.mapper;

import java.util.List;

import com.maven.ssm.pojo.BaseDict;

public interface BaseDictMapper {
	public List<BaseDict> getBaseDictById(String id);
	
	public List<BaseDict> getBaseDictByTypeCode(String code);
}
