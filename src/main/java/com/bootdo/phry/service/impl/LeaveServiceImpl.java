package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.ConvertDomainUtils;
import com.bootdo.common.utils.R;
import com.bootdo.phry.dao.LeaveDao;
import com.bootdo.phry.domain.LeaveDO;
import com.bootdo.phry.dto.LeaveDTO;
import com.bootdo.phry.service.LeaveService;



@Service
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveDao leaveDao;
	
	@Override
	public LeaveDTO get(Integer id){

		LeaveDO leaveDO = leaveDao.get(id);
        if (leaveDO != null){
            return ConvertDomainUtils.convertObject(leaveDO,LeaveDTO.class);
        }
		return null;
	}
	
	@Override
	public List<LeaveDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(leaveDao.list(map),LeaveDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return leaveDao.count(map);
	}
	
	@Override
	public R save(LeaveDTO leave){
        int i = leaveDao.save(ConvertDomainUtils.convertObject(leave,LeaveDO.class));
        return R.result(i);
	}
	
	@Override
	public R update(LeaveDTO leave){
        int i = leaveDao.update(ConvertDomainUtils.convertObject(leave,LeaveDO.class));
        return R.result(i);
	}
	
	@Override
	public int remove(Integer id){
		return leaveDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return leaveDao.batchRemove(ids);
	}
	
}
