package com.bootdo.phry.service;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.phry.domain.UserInfoDO;
import com.bootdo.phry.domain.WorkHistoryDO;
import com.bootdo.phry.dto.UserInfoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-22 10:43:57
 */
public interface UserInfoService {
	
	UserInfoDTO get(Long userId);
	
	List<UserInfoDTO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(UserInfoDTO user);
	
	R update(UserInfoDTO user);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);

	int mancount();

	int womancount();

	int age1();

	int age2();

	int age3();

	int age4();

	int age5();

	int age6();

	int study1();

	int study2();

	int study3();

	int study4();

	int study5();

	int study6();

	int work1();

	int work2();

	int work3();

	int work4();

	List<WorkHistoryDO> getWorkHistoryList();
	
	List<UserInfoDTO> listweixin(Map<String, Object> map);
	
	int countweixin(Map<String, Object> map);
	//所有数据的数量
	int allcount();
	//部门数据的数量
	int partCount(Long deptId);

	void updateSort(int change);
	
	void updateSort2(int change);

	Integer getSortCount(Integer allsort);

	List<UserInfoDO> listLocal(HashMap<String, Object> params);

}
