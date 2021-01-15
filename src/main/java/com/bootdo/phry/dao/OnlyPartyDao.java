package com.bootdo.phry.dao;

import com.bootdo.phry.domain.OnlyPartyDO;
import com.bootdo.phry.dto.OnlyPartyDTO;

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
public interface OnlyPartyDao {

	OnlyPartyDO get(Long partyId);
	
	List<OnlyPartyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OnlyPartyDO party);
	
	int update(OnlyPartyDO party);
	
	int remove(Long party_id);
	
	int batchRemove(Long[] partyIds);
	OnlyPartyDO searchFile(Long userId);
}
