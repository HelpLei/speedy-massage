package com.bootdo.phry.dao;

import com.bootdo.phry.domain.PersonFileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2020-04-14 11:36:29
 */
@Mapper
public interface PersonFileDao {

	PersonFileDO get(Integer id);
	
	List<PersonFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PersonFileDO personFile);
	
	int update(PersonFileDO personFile);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
