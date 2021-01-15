package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.ConvertDomainUtils;
import com.bootdo.common.utils.R;
import com.bootdo.phry.dao.PactDao;
import com.bootdo.phry.domain.PactDO;
import com.bootdo.phry.dto.PactDTO;
import com.bootdo.phry.service.PactService;



@Service
public class PactServiceImpl implements PactService {
	@Autowired
	private PactDao pactDao;
	
	@Override
	public PactDTO get(Integer id){

		PactDO pactDO = pactDao.get(id);
        if (pactDO != null){
            return ConvertDomainUtils.convertObject(pactDO,PactDTO.class);
        }
		return null;
	}
	
	@Override
	public List<PactDTO> list(Map<String, Object> map){
		return ConvertDomainUtils.convertList(pactDao.list(map),PactDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return pactDao.count(map);
	}
	
	@Override
	public R save(PactDTO pact){
        int i = pactDao.save(ConvertDomainUtils.convertObject(pact,PactDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(PactDTO pact){
        int i = pactDao.update(ConvertDomainUtils.convertObject(pact,PactDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return pactDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return pactDao.batchRemove(ids);
	}
	
}
