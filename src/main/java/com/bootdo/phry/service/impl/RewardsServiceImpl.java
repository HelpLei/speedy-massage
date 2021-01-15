package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.RewardsDao;
import com.bootdo.phry.domain.RewardsDO;
import com.bootdo.phry.dto.RewardsDTO;
import com.bootdo.phry.service.RewardsService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class RewardsServiceImpl implements RewardsService {
	@Autowired
	private RewardsDao rewardsDao;
	
	@Override
	public RewardsDTO get(Long rewardsId){

		RewardsDO rewardsDO = rewardsDao.get(rewardsId);
        if (rewardsDO != null){
            return ConvertDomainUtils.convertObject(rewardsDO,RewardsDTO.class);
        }
		return  new RewardsDTO();
	}
	
	@Override
	public List<RewardsDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(rewardsDao.list(map),RewardsDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return rewardsDao.count(map);
	}
	
	@Override
	public R save(RewardsDTO rewards){
        int i = rewardsDao.save(ConvertDomainUtils.convertObject(rewards,RewardsDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(RewardsDTO rewards){
        int i = rewardsDao.update(ConvertDomainUtils.convertObject(rewards,RewardsDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long rewardsId){
		return rewardsDao.remove(rewardsId);
	}
	
	@Override
	public int batchRemove(Long[] rewardsIds){
		return rewardsDao.batchRemove(rewardsIds);
	}

	@Override
	public RewardsDO searchFile(Long userId) {
		return rewardsDao.searchFile(userId);
	}
	
}
