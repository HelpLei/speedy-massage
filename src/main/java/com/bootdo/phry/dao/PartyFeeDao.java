package com.bootdo.phry.dao;

import com.bootdo.phry.domain.PartyFeeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-04 16:47:00
 */
@Mapper
public interface PartyFeeDao {

	PartyFeeDO get(Long id);
	
	List<PartyFeeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PartyFeeDO partyFee);
	
	int update(PartyFeeDO partyFee);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
