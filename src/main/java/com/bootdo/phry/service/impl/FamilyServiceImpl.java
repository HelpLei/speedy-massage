package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.FamilyDao;
import com.bootdo.phry.domain.FamilyDO;
import com.bootdo.phry.dto.FamilyDTO;
import com.bootdo.phry.service.FamilyService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class FamilyServiceImpl implements FamilyService {
	@Autowired
	private FamilyDao familyDao;
	
	@Override
	public FamilyDTO get(Long familyId){

		FamilyDO familyDO = familyDao.get(familyId);
        if (familyDO != null){
            return ConvertDomainUtils.convertObject(familyDO,FamilyDTO.class);
        }
		return  new FamilyDTO();
	}
	
	@Override
	public List<FamilyDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(familyDao.list(map),FamilyDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return familyDao.count(map);
	}
	
	@Override
	public R save(FamilyDTO family){
        int i = familyDao.save(ConvertDomainUtils.convertObject(family,FamilyDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(FamilyDTO family){
        int i = familyDao.update(ConvertDomainUtils.convertObject(family,FamilyDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long familyId){
		return familyDao.remove(familyId);
	}
	
	@Override
	public int batchRemove(Long[] familyIds){
		return familyDao.batchRemove(familyIds);
	}
	
}
