package com.bootdo.phry.dao;

import com.bootdo.phry.domain.RetireDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 缴纳党费信息录入
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 10:06:33
 */
@Mapper
public interface RetireDao {

	RetireDO get(Long id);
	
	List<RetireDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	List<RetireDO> list2(Map<String,Object> map);
	
	int count2(Map<String,Object> map);
	
	int save(RetireDO retire);
	
	int update(RetireDO retire);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
