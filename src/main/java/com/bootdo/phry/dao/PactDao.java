package com.bootdo.phry.dao;

import com.bootdo.phry.domain.PactDO;
import com.bootdo.phry.dto.PactDTO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 15:53:38
 */
@Mapper
public interface PactDao {

	PactDO get(Integer id);
	
	List<PactDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PactDO pact);
	
	int update(PactDO pact);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
