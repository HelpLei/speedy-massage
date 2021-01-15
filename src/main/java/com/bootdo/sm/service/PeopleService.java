package com.bootdo.sm.service;

import com.bootdo.sm.dto.PeopleDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 被服务人员姓名
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public interface PeopleService {
	
	PeopleDTO get(Integer id);
	
	List<PeopleDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(PeopleDTO people);
	
	R update(PeopleDTO people);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
