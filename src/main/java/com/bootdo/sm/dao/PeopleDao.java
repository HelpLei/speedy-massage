package com.bootdo.sm.dao;

import com.bootdo.sm.domain.PeopleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 被服务人员姓名
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Mapper
public interface PeopleDao {

	PeopleDO get(Integer id);
	
	List<PeopleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PeopleDO people);
	
	int update(PeopleDO people);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
