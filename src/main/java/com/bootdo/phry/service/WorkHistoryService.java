package com.bootdo.phry.service;

import com.bootdo.phry.dto.WorkHistoryDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
public interface WorkHistoryService {
	
	WorkHistoryDTO get(Long workId);
	
	List<WorkHistoryDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(WorkHistoryDTO workHistory);
	
	R update(WorkHistoryDTO workHistory);
	
	int remove(Long workId);
	
	int batchRemove(Long[] workIds);
}
