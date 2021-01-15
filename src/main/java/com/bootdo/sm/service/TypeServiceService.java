package com.bootdo.sm.service;

import com.bootdo.sm.dto.TypeServiceDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 服务类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public interface TypeServiceService {
	
	TypeServiceDTO get(Integer id);
	
	List<TypeServiceDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(TypeServiceDTO typeService);
	
	R update(TypeServiceDTO typeService);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
