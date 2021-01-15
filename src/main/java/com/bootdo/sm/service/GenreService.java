package com.bootdo.sm.service;

import com.bootdo.sm.dto.GenreDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 个人类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public interface GenreService {
	
	GenreDTO get(Integer id);
	
	List<GenreDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(GenreDTO genre);
	
	R update(GenreDTO genre);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
