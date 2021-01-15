package com.bootdo.phry.dao;

import com.bootdo.phry.domain.PartyDO;
import com.bootdo.phry.dto.PartyDTO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 党籍表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
@Mapper
public interface PartyDao {

	PartyDO get(Long partyId);
	
	List<PartyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PartyDO party);
	
	int update(PartyDO party);
	
	int remove(Long party_id);
	
	int batchRemove(Long[] partyIds);
	PartyDO searchFile(Long userId);
}
