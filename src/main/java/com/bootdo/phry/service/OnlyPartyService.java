package com.bootdo.phry.service;

import com.bootdo.phry.domain.OnlyPartyDO;
import com.bootdo.phry.dto.OnlyPartyDTO;

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
public interface OnlyPartyService {
	
	OnlyPartyDTO get(Long partyId);
	
	List<OnlyPartyDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(OnlyPartyDTO party);
	
	R update(OnlyPartyDTO party);
	
	int remove(Long partyId);
	
	int batchRemove(Long[] partyIds);

	OnlyPartyDO searchFile(Long userId);


}
