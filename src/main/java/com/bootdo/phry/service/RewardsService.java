package com.bootdo.phry.service;

import com.bootdo.phry.domain.RewardsDO;
import com.bootdo.phry.dto.RewardsDTO;

import java.util.List;
import java.util.Map;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
public interface RewardsService {
	
	RewardsDTO get(Long rewardsId);
	
	List<RewardsDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(RewardsDTO rewards);
	
	R update(RewardsDTO rewards);
	
	int remove(Long rewardsId);
	
	int batchRemove(Long[] rewardsIds);

	RewardsDO searchFile(Long userId);
}
