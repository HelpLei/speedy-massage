package com.bootdo.phry.service;

import com.bootdo.phry.domain.CheckDO;
import com.bootdo.phry.dto.CheckDTO;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
public interface CheckService {
	
	CheckDTO get(Long checkId);
	
	List<CheckDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(CheckDTO check);
	
	R update(CheckDTO check);
	
	int remove(Long checkId);
	
	int batchRemove(Long[] checkIds);

	CheckDO searchFile(Long userId);

	List<CheckDTO> CRlist(Query query);

	int CRcount(Query query);
}
