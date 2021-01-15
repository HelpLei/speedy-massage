package com.bootdo.phry.service;

import com.bootdo.phry.dto.LeaveDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 请假表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 10:23:55
 */
public interface LeaveService {
	
	LeaveDTO get(Integer id);
	
	List<LeaveDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(LeaveDTO leave);
	
	R update(LeaveDTO leave);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
