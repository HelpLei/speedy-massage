package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.PersonFileDao;
import com.bootdo.phry.domain.PersonFileDO;
import com.bootdo.phry.dto.PersonFileDTO;
import com.bootdo.phry.service.PersonFileService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class PersonFileServiceImpl implements PersonFileService {
	@Autowired
	private PersonFileDao personFileDao;
	
	@Override
	public PersonFileDTO get(Integer id){

		PersonFileDO personFileDO = personFileDao.get(id);
        if (personFileDO != null){
            return ConvertDomainUtils.convertObject(personFileDO,PersonFileDTO.class);
        }
		return  new PersonFileDTO();
	}
	
	@Override
	public List<PersonFileDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(personFileDao.list(map),PersonFileDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return personFileDao.count(map);
	}
	
	@Override
	public R save(PersonFileDTO personFile){
        int i = personFileDao.save(ConvertDomainUtils.convertObject(personFile,PersonFileDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(PersonFileDTO personFile){
        int i = personFileDao.update(ConvertDomainUtils.convertObject(personFile,PersonFileDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return personFileDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return personFileDao.batchRemove(ids);
	}
	
}
