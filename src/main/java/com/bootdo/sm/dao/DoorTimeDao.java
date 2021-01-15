package com.bootdo.sm.dao;

import com.bootdo.sm.domain.DoorTimeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Mapper
public interface DoorTimeDao {

	DoorTimeDO get(Integer id);
	
	List<DoorTimeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DoorTimeDO doorTime);
	
	int update(DoorTimeDO doorTime);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
