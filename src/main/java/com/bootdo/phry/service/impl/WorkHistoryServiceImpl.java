package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.WorkHistoryDao;
import com.bootdo.phry.domain.WorkHistoryDO;
import com.bootdo.phry.dto.WorkHistoryDTO;
import com.bootdo.phry.service.WorkHistoryService;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ConvertDomainUtils;



@Service
public class WorkHistoryServiceImpl implements WorkHistoryService {
	@Autowired
	private WorkHistoryDao workHistoryDao;
	
	@Override
	public WorkHistoryDTO get(Long workId){

		WorkHistoryDO workHistoryDO = workHistoryDao.get(workId);
        if (workHistoryDO != null){
            return ConvertDomainUtils.convertObject(workHistoryDO,WorkHistoryDTO.class);
        }
		return  new WorkHistoryDTO();
	}
	
	@Override
	public List<WorkHistoryDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(workHistoryDao.list(map),WorkHistoryDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return workHistoryDao.count(map);
	}
	
	@Override
	public R save(WorkHistoryDTO workHistory){
        int i = workHistoryDao.save(ConvertDomainUtils.convertObject(workHistory,WorkHistoryDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(WorkHistoryDTO workHistory){
        int i = workHistoryDao.update(ConvertDomainUtils.convertObject(workHistory,WorkHistoryDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Long workId){
		return workHistoryDao.remove(workId);
	}
	
	@Override
	public int batchRemove(Long[] workIds){
		return workHistoryDao.batchRemove(workIds);
	}
	
}
