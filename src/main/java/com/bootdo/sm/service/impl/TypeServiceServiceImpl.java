package com.bootdo.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sm.dao.TypeServiceDao;
import com.bootdo.sm.domain.TypeServiceDO;
import com.bootdo.sm.dto.TypeServiceDTO;
import com.bootdo.sm.service.TypeServiceService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class TypeServiceServiceImpl implements TypeServiceService {
	@Autowired
	private TypeServiceDao typeServiceDao;
	
	@Override
	public TypeServiceDTO get(Integer id){

		TypeServiceDO typeServiceDO = typeServiceDao.get(id);
        if (typeServiceDO != null){
            return ConvertDomainUtils.convertObject(typeServiceDO,TypeServiceDTO.class);
        }
		return  new TypeServiceDTO();
	}
	
	@Override
	public List<TypeServiceDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(typeServiceDao.list(map),TypeServiceDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return typeServiceDao.count(map);
	}
	
	@Override
	public R save(TypeServiceDTO typeService){
        int i = typeServiceDao.save(ConvertDomainUtils.convertObject(typeService,TypeServiceDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(TypeServiceDTO typeService){
        int i = typeServiceDao.update(ConvertDomainUtils.convertObject(typeService,TypeServiceDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return typeServiceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return typeServiceDao.batchRemove(ids);
	}
	
}
