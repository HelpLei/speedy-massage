package com.bootdo.sm.dao;

import com.bootdo.sm.domain.TechnicianDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 技师人员
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Mapper
public interface TechnicianDao {

	TechnicianDO get(Integer id);
	
	List<TechnicianDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TechnicianDO technician);
	
	int update(TechnicianDO technician);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
