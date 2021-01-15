package com.bootdo.phry.service;

import com.bootdo.phry.dto.PersonFileDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2020-04-14 11:36:29
 */
public interface PersonFileService {
	
	PersonFileDTO get(Integer id);
	
	List<PersonFileDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(PersonFileDTO personFile);
	
	R update(PersonFileDTO personFile);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
