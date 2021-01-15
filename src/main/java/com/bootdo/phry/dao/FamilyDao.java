package com.bootdo.phry.dao;

import com.bootdo.phry.domain.FamilyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 家庭成员表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
@Mapper
public interface FamilyDao {

	FamilyDO get(Long familyId);
	
	List<FamilyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FamilyDO family);
	
	int update(FamilyDO family);
	
	int remove(Long family_id);
	
	int batchRemove(Long[] familyIds);
}
