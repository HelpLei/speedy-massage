package com.bootdo.phry.service.impl;

import com.bootdo.common.utils.ConvertDomainUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.phry.domain.WorkHistoryDO;
import com.bootdo.phry.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.phry.dao.UserInfoDao;
import com.bootdo.phry.domain.UserInfoDO;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.common.utils.R;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userDao;
	
	@Override
	public UserInfoDTO get(Long userId){

		UserInfoDO userDO = userDao.get(userId);
        if (userDO != null){
            return ConvertDomainUtils.convertObject(userDO,UserInfoDTO.class);
        }
		return null;
	}
	
	@Override
	public List<UserInfoDTO> list(Map<String, Object> map){
        return ConvertDomainUtils.convertList(userDao.list(map),UserInfoDTO.class);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userDao.count(map);
	}
	
	@Override
	public R save(UserInfoDTO user){
		UserInfoDO userInfoDO = ConvertDomainUtils.convertObject(user,UserInfoDO.class);
        userDao.save(userInfoDO);
		System.out.println(userInfoDO.getUserId());
		return R.ok().put("userId",userInfoDO.getUserId());
	}
	
	@Override
	public R update(UserInfoDTO user){
        int i = userDao.update(ConvertDomainUtils.convertObject(user,UserInfoDO.class));
		return R.result(i);
	}
	
	@Override
	public int remove(Long userId){
		return userDao.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return userDao.batchRemove(userIds);
	}

	@Override
	public int mancount() {
		return userDao.mancount();
	}

	public int womancount() {
		return userDao.womancount();
	}

	@Override
	public int age1() {
		return userDao.age1();
	}

	@Override
	public int age2() {
		return userDao.age2();
	}

	@Override
	public int age3() {
		return userDao.age3();
	}

	@Override
	public int age4() {
		return userDao.age4();
	}

	@Override
	public int age5() {
		return userDao.age5();
	}

	@Override
	public int age6() {
		return userDao.age6();
	}

	@Override
	public int study1() {
		return userDao.study1();
	}

	@Override
	public int study2() {
		return userDao.study2();
	}

	@Override
	public int study3() {
		return userDao.study3();
	}

	@Override
	public int study4() {
		return userDao.study4();
	}

	@Override
	public int study5() {
		return userDao.study5();
	}

	@Override
	public int study6() {
		return userDao.study6();
	}

	@Override
	public int work1() {
		return userDao.work1();
	}

	@Override
	public int work2() {
		return userDao.work2();
	}

	@Override
	public int work3() {
		return userDao.work3();
	}

	@Override
	public int work4() {
		return userDao.work4();
	}

	@Override
	public List<WorkHistoryDO> getWorkHistoryList() {
		return userDao.getWorkHistoryList();
	}

	
	@Override
	public List<UserInfoDTO> listweixin(Map<String, Object> map){
        return ConvertDomainUtils.convertList(userDao.listweixin(map),UserInfoDTO.class);
	}
	
	@Override
	public int countweixin(Map<String, Object> map){
		return userDao.countweixin(map);
	}

	@Override
	public int allcount() {
		return userDao.allcount();
	}

	@Override
	public int partCount(Long deptId) {
		return userDao.partCount(deptId);
	}

	@Override
	public void updateSort(int change) {
		userDao.updateSort(change);
	}
	
	@Override
	public void updateSort2(int change) {
		userDao.updateSort2(change);
	}

	@Override
	public Integer getSortCount(Integer allsort) {
		return userDao.getSortCount(allsort);
	}

	@Override
	public List<UserInfoDO> listLocal(HashMap<String, Object> params) {
		return userDao.listLocal(params);
	}
}
