package com.bootdo.phry.service;

import com.bootdo.phry.dto.RetireDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 缴纳党费信息录入
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 10:06:33
 */
public interface RetireService {
	
	RetireDTO get(Long id);
	
	List<RetireDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	List<RetireDTO> list2(Map<String, Object> map);
	
	int count2(Map<String, Object> map);
	
	R save(RetireDTO retire);
	
	R update(RetireDTO retire);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
