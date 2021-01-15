package com.bootdo.phry.service.impl;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.EducationDao;
import com.bootdo.phry.domain.EducationDO;
import com.bootdo.phry.dto.EducationDTO;
import com.bootdo.phry.service.EducationService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class EducationServiceImpl implements EducationService {
	@Autowired
	private EducationDao educationDao;
	
	@Override
	public EducationDTO get(Long educationId){

		EducationDO educationDO = educationDao.get(educationId);
        if (educationDO != null){
            return ConvertDomainUtils.convertObject(educationDO,EducationDTO.class);
        }
		return  new EducationDTO();
	}
	
	@Override
	public List<EducationDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(educationDao.list(map),EducationDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return educationDao.count(map);
	}
	
	@Override
	public R save(EducationDTO education){
        int i = educationDao.save(ConvertDomainUtils.convertObject(education,EducationDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(EducationDTO education){
        int i = educationDao.update(ConvertDomainUtils.convertObject(education,EducationDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long educationId){
		return educationDao.remove(educationId);
	}
	
	@Override
	public int batchRemove(Long[] educationIds){
		return educationDao.batchRemove(educationIds);
	}

	@Override
	public R setHeightEdu(Long educationId) {
		EducationDO educationDO = educationDao.get(educationId);
		Map map = new HashedMap();
		map.put("userId",educationDO.getUserId());
		List<EducationDO> educationDOS = educationDao.list(map);

		for (EducationDO e:educationDOS) {
			if(educationDO.getEducationId().equals(e.getEducationId())){
				e.setHeightEdu(1);
				educationDao.update(e);
			}else{
				e.setHeightEdu(0);
				educationDao.update(e);
			}
		}
		return R.ok();
	}
}
