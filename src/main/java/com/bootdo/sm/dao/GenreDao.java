package com.bootdo.sm.dao;

import com.bootdo.sm.domain.GenreDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 个人类型
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Mapper
public interface GenreDao {

	GenreDO get(Integer id);
	
	List<GenreDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GenreDO genre);
	
	int update(GenreDO genre);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
