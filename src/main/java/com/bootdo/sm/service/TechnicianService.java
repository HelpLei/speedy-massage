package com.bootdo.sm.service;

import com.bootdo.sm.dto.TechnicianDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 技师人员
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public interface TechnicianService {
	
	TechnicianDTO get(Integer id);
	
	List<TechnicianDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(TechnicianDTO technician);
	
	R update(TechnicianDTO technician);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
