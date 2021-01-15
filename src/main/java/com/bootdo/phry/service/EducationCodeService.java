package com.bootdo.phry.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.phry.dto.EducationCodeDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 学历代码表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 09:28:39
 */
public interface EducationCodeService {
	
	EducationCodeDTO get(Long educationCodeId);
	
	List<EducationCodeDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(EducationCodeDTO educationCode);
	
	R update(EducationCodeDTO educationCode);
	
	int remove(Long educationCodeId);
	
	int batchRemove(Long[] educationCodeIds);

    Tree<EducationCodeDTO> getTree();

}
