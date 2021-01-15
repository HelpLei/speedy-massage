package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.RetireDao;
import com.bootdo.phry.domain.RetireDO;
import com.bootdo.phry.dto.RetireDTO;
import com.bootdo.phry.service.RetireService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class RetireServiceImpl implements RetireService {
	@Autowired
	private RetireDao retireDao;
	
	@Override
	public RetireDTO get(Long id){

		RetireDO retireDO = retireDao.get(id);
        if (retireDO != null){
            return ConvertDomainUtils.convertObject(retireDO,RetireDTO.class);
        }
		return  new RetireDTO();
	}
	
	@Override
	public List<RetireDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(retireDao.list(map),RetireDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return retireDao.count(map);
	}
	
	@Override
	public List<RetireDTO> list2(Map<String, Object> map){
        return ConvertDomainUtils.convertList(retireDao.list2(map),RetireDTO.class);
	}
	
	@Override
	public int count2(Map<String, Object> map){
		return retireDao.count2(map);
	}
	
	@Override
	public R save(RetireDTO retire){
        int i = retireDao.save(ConvertDomainUtils.convertObject(retire,RetireDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(RetireDTO retire){
        int i = retireDao.update(ConvertDomainUtils.convertObject(retire,RetireDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long id){
		return retireDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return retireDao.batchRemove(ids);
	}
	
}
