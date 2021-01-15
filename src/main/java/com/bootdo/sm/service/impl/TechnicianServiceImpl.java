package com.bootdo.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sm.dao.TechnicianDao;
import com.bootdo.sm.domain.TechnicianDO;
import com.bootdo.sm.dto.TechnicianDTO;
import com.bootdo.sm.service.TechnicianService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class TechnicianServiceImpl implements TechnicianService {
	@Autowired
	private TechnicianDao technicianDao;
	
	@Override
	public TechnicianDTO get(Integer id){

		TechnicianDO technicianDO = technicianDao.get(id);
        if (technicianDO != null){
            return ConvertDomainUtils.convertObject(technicianDO,TechnicianDTO.class);
        }
		return  new TechnicianDTO();
	}
	
	@Override
	public List<TechnicianDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(technicianDao.list(map),TechnicianDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return technicianDao.count(map);
	}
	
	@Override
	public R save(TechnicianDTO technician){
        int i = technicianDao.save(ConvertDomainUtils.convertObject(technician,TechnicianDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(TechnicianDTO technician){
        int i = technicianDao.update(ConvertDomainUtils.convertObject(technician,TechnicianDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return technicianDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return technicianDao.batchRemove(ids);
	}
	
}
