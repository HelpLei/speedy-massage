package com.bootdo.sm.dao;

import com.bootdo.sm.domain.TypeServiceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 服务类型
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Mapper
public interface TypeServiceDao {

	TypeServiceDO get(Integer id);
	
	List<TypeServiceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TypeServiceDO typeService);
	
	int update(TypeServiceDO typeService);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
