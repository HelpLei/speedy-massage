package com.bootdo.phry.dao;

import com.bootdo.phry.domain.EducationCodeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 学历代码表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 09:28:39
 */
@Mapper
public interface EducationCodeDao {

	EducationCodeDO get(Long educationCodeId);
	
	List<EducationCodeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(EducationCodeDO educationCode);
	
	int update(EducationCodeDO educationCode);
	
	int remove(Long education_code_id);
	
	int batchRemove(Long[] educationCodeIds);
}
