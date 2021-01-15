package com.bootdo.phry.dao;

import com.bootdo.phry.domain.WorkHistoryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 家庭成员表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
@Mapper
public interface WorkHistoryDao {

	WorkHistoryDO get(Long workId);
	
	List<WorkHistoryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WorkHistoryDO workHistory);
	
	int update(WorkHistoryDO workHistory);
	
	int remove(Long work_id);
	
	int batchRemove(Long[] workIds);
}
