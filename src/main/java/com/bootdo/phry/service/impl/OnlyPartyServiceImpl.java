package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.OnlyPartyDao;
import com.bootdo.phry.domain.OnlyPartyDO;
import com.bootdo.phry.dto.OnlyPartyDTO;
import com.bootdo.phry.service.OnlyPartyService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class OnlyPartyServiceImpl implements OnlyPartyService {
	@Autowired
	private OnlyPartyDao partyDao;
	
	@Override
	public OnlyPartyDTO get(Long partyId){

		OnlyPartyDO partyDO = partyDao.get(partyId);
        if (partyDO != null){
            return ConvertDomainUtils.convertObject(partyDO,OnlyPartyDTO.class);
        }
		return  new OnlyPartyDTO();
	}
	
	@Override
	public List<OnlyPartyDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(partyDao.list(map),OnlyPartyDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return partyDao.count(map);
	}
	
	@Override
	public R save(OnlyPartyDTO party){
        int i = partyDao.save(ConvertDomainUtils.convertObject(party,OnlyPartyDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(OnlyPartyDTO party){
        int i = partyDao.update(ConvertDomainUtils.convertObject(party,OnlyPartyDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long partyId){
		return partyDao.remove(partyId);
	}
	
	@Override
	public int batchRemove(Long[] partyIds){
		return partyDao.batchRemove(partyIds);
	}

	@Override
	public OnlyPartyDO searchFile(Long userId) {
		return partyDao.searchFile(userId);
	}
	
}
