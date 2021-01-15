package com.bootdo.phry.service;

import com.bootdo.phry.dto.PactDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 15:53:38
 */
public interface PactService {
	
	PactDTO get(Integer id);
	
	List<PactDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(PactDTO pact);
	
	R update(PactDTO pact);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
