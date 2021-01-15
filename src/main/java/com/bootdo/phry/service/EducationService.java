package com.bootdo.phry.service;

import com.bootdo.phry.dto.EducationDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 学历表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
public interface EducationService {
	
	EducationDTO get(Long educationId);
	
	List<EducationDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(EducationDTO education);
	
	R update(EducationDTO education);
	
	int remove(Long educationId);
	
	int batchRemove(Long[] educationIds);

    R setHeightEdu(Long educationId);
}
