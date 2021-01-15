package com.bootdo.phry.service;

import com.bootdo.phry.dto.FamilyDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
public interface FamilyService {
	
	FamilyDTO get(Long familyId);
	
	List<FamilyDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(FamilyDTO family);
	
	R update(FamilyDTO family);
	
	int remove(Long familyId);
	
	int batchRemove(Long[] familyIds);
}
