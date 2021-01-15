package com.bootdo.phry.service;

import com.bootdo.phry.domain.PartyDO;
import com.bootdo.phry.dto.PartyDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 党籍表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
public interface PartyService {
	
	PartyDTO get(Long partyId);
	
	List<PartyDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(PartyDTO party);
	
	R update(PartyDTO party);
	
	int remove(Long partyId);
	
	int batchRemove(Long[] partyIds);

	PartyDO searchFile(Long userId);


}
