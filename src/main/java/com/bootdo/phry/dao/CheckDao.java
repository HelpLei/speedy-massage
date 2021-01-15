package com.bootdo.phry.dao;

import com.bootdo.common.utils.Query;
import com.bootdo.phry.domain.CheckDO;
import com.bootdo.phry.dto.CheckDTO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
@Mapper
public interface CheckDao {

	CheckDO get(Long checkId);
	
	List<CheckDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(CheckDO check);
	
	int update(CheckDO check);
	
	int remove(Long check_id);
	
	int batchRemove(Long[] checkIds);
	
	CheckDO searchFile(Long userId);
	
	List<CheckDTO> CRlist(Query query);
	
	int CRcount(Query query);
}
