package com.bootdo.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sm.dao.DoorTimeDao;
import com.bootdo.sm.domain.DoorTimeDO;
import com.bootdo.sm.dto.DoorTimeDTO;
import com.bootdo.sm.service.DoorTimeService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class DoorTimeServiceImpl implements DoorTimeService {
	@Autowired
	private DoorTimeDao doorTimeDao;
	
	@Override
	public DoorTimeDTO get(Integer id){

		DoorTimeDO doorTimeDO = doorTimeDao.get(id);
        if (doorTimeDO != null){
            return ConvertDomainUtils.convertObject(doorTimeDO,DoorTimeDTO.class);
        }
		return  new DoorTimeDTO();
	}
	
	@Override
	public List<DoorTimeDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(doorTimeDao.list(map),DoorTimeDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return doorTimeDao.count(map);
	}
	
	@Override
	public R save(DoorTimeDTO doorTime){
        int i = doorTimeDao.save(ConvertDomainUtils.convertObject(doorTime,DoorTimeDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(DoorTimeDTO doorTime){
        int i = doorTimeDao.update(ConvertDomainUtils.convertObject(doorTime,DoorTimeDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return doorTimeDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return doorTimeDao.batchRemove(ids);
	}
	
}
