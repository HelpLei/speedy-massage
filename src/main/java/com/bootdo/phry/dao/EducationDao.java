package com.bootdo.phry.dao;

import com.bootdo.phry.domain.EducationDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学历表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
@Mapper
public interface EducationDao {

	EducationDO get(Long educationId);
	
	List<EducationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EducationDO education);
	
	int update(EducationDO education);
	
	int remove(Long education_id);
	
	int batchRemove(Long[] educationIds);
}
