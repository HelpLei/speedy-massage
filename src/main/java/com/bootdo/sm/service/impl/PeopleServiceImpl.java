package com.bootdo.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sm.dao.PeopleDao;
import com.bootdo.sm.domain.PeopleDO;
import com.bootdo.sm.dto.PeopleDTO;
import com.bootdo.sm.service.PeopleService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public PeopleDTO get(Integer id){

		PeopleDO peopleDO = peopleDao.get(id);
        if (peopleDO != null){
            return ConvertDomainUtils.convertObject(peopleDO,PeopleDTO.class);
        }
		return  new PeopleDTO();
	}
	
	@Override
	public List<PeopleDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(peopleDao.list(map),PeopleDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return peopleDao.count(map);
	}
	
	@Override
	public R save(PeopleDTO people){
        int i = peopleDao.save(ConvertDomainUtils.convertObject(people,PeopleDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(PeopleDTO people){
        int i = peopleDao.update(ConvertDomainUtils.convertObject(people,PeopleDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return peopleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return peopleDao.batchRemove(ids);
	}
	
}
