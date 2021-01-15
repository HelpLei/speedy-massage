package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.PartyFeeDao;
import com.bootdo.phry.domain.PartyFeeDO;
import com.bootdo.phry.dto.PartyFeeDTO;
import com.bootdo.phry.service.PartyFeeService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class PartyFeeServiceImpl implements PartyFeeService {
	@Autowired
	private PartyFeeDao partyFeeDao;
	
	@Override
	public PartyFeeDTO get(Long id){

		PartyFeeDO partyFeeDO = partyFeeDao.get(id);
        if (partyFeeDO != null){
            return ConvertDomainUtils.convertObject(partyFeeDO,PartyFeeDTO.class);
        }
		return  new PartyFeeDTO();
	}
	
	@Override
	public List<PartyFeeDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(partyFeeDao.list(map),PartyFeeDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return partyFeeDao.count(map);
	}
	
	@Override
	public R save(PartyFeeDTO partyFee){
        int i = partyFeeDao.save(ConvertDomainUtils.convertObject(partyFee,PartyFeeDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(PartyFeeDTO partyFee){
        int i = partyFeeDao.update(ConvertDomainUtils.convertObject(partyFee,PartyFeeDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long id){
		return partyFeeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return partyFeeDao.batchRemove(ids);
	}
	
}
