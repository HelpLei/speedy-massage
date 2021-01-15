package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.CheckDao;
import com.bootdo.phry.domain.CheckDO;
import com.bootdo.phry.dto.CheckDTO;
import com.bootdo.phry.service.CheckService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;
import com.bootdo.common.utils.Query;



@Service
public class CheckServiceImpl implements CheckService {
	@Autowired
	private CheckDao checkDao;
	
	@Override
	public CheckDTO get(Long checkId){

		CheckDO checkDO = checkDao.get(checkId);
        if (checkDO != null){
            return ConvertDomainUtils.convertObject(checkDO,CheckDTO.class);
        }
		return  new CheckDTO();
	}
	
	@Override
	public List<CheckDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(checkDao.list(map),CheckDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return checkDao.count(map);
	}
	
	@Override
	public R save(CheckDTO check){
        int i = checkDao.save(ConvertDomainUtils.convertObject(check,CheckDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(CheckDTO check){
        int i = checkDao.update(ConvertDomainUtils.convertObject(check,CheckDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long checkId){
		return checkDao.remove(checkId);
	}
	
	@Override
	public int batchRemove(Long[] checkIds){
		return checkDao.batchRemove(checkIds);
	}

	@Override
	public CheckDO searchFile(Long userId) {
		return checkDao.searchFile(userId);
	}

	@Override
	public List<CheckDTO> CRlist(Query query) {
		return checkDao.CRlist(query);
	}

	@Override
	public int CRcount(Query query) {
		return checkDao.CRcount(query);
	}
	
}
