package com.bootdo.phry.dao;

import com.bootdo.phry.domain.LeaveDO;
import com.bootdo.phry.dto.LeaveDTO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 请假表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 10:23:55
 */
@Mapper
public interface LeaveDao {

	LeaveDO get(Integer id);
	
	List<LeaveDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(LeaveDO leave);
	
	int update(LeaveDO leave);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
