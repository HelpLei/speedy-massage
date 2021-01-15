package com.bootdo.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sm.dao.GenreDao;
import com.bootdo.sm.domain.GenreDO;
import com.bootdo.sm.dto.GenreDTO;
import com.bootdo.sm.service.GenreService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreDao genreDao;
	
	@Override
	public GenreDTO get(Integer id){

		GenreDO genreDO = genreDao.get(id);
        if (genreDO != null){
            return ConvertDomainUtils.convertObject(genreDO,GenreDTO.class);
        }
		return  new GenreDTO();
	}
	
	@Override
	public List<GenreDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(genreDao.list(map),GenreDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return genreDao.count(map);
	}
	
	@Override
	public R save(GenreDTO genre){
        int i = genreDao.save(ConvertDomainUtils.convertObject(genre,GenreDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(GenreDTO genre){
        int i = genreDao.update(ConvertDomainUtils.convertObject(genre,GenreDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return genreDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return genreDao.batchRemove(ids);
	}
	
}
