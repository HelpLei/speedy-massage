package com.bootdo.sm.service;

import com.bootdo.sm.dto.DoorTimeDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public interface DoorTimeService {
	
	DoorTimeDTO get(Integer id);
	
	List<DoorTimeDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(DoorTimeDTO doorTime);
	
	R update(DoorTimeDTO doorTime);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
