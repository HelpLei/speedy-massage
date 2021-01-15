package com.bootdo.phry.dao;

import com.bootdo.phry.domain.RewardsDO;

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
public interface RewardsDao {

	RewardsDO get(Long rewardsId);
	
	List<RewardsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RewardsDO rewards);
	
	int update(RewardsDO rewards);
	
	int remove(Long rewards_id);
	
	int batchRemove(Long[] rewardsIds);
	
	RewardsDO searchFile(Long userId);
}
