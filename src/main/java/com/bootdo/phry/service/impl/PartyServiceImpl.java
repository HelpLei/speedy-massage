package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.PartyDao;
import com.bootdo.phry.domain.PartyDO;
import com.bootdo.phry.dto.PartyDTO;
import com.bootdo.phry.service.PartyService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class PartyServiceImpl implements PartyService {
	@Autowired
	private PartyDao partyDao;
	
	@Override
	public PartyDTO get(Long partyId){

		PartyDO partyDO = partyDao.get(partyId);
        if (partyDO != null){
            return ConvertDomainUtils.convertObject(partyDO,PartyDTO.class);
        }
		return  new PartyDTO();
	}
	
	@Override
	public List<PartyDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(partyDao.list(map),PartyDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return partyDao.count(map);
	}
	
	@Override
	public R save(PartyDTO party){
        int i = partyDao.save(ConvertDomainUtils.convertObject(party,PartyDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(PartyDTO party){
        int i = partyDao.update(ConvertDomainUtils.convertObject(party,PartyDO.class));
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
	public PartyDO searchFile(Long userId) {
		return partyDao.searchFile(userId);
	}
	
}
