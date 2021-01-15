package com.bootdo.phry.service;

import com.bootdo.phry.dto.PartyFeeDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-04 16:47:00
 */
public interface PartyFeeService {
	
	PartyFeeDTO get(Long id);
	
	List<PartyFeeDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(PartyFeeDTO partyFee);
	
	R update(PartyFeeDTO partyFee);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
