package com.bootdo.phry.dao;

import com.bootdo.phry.domain.DeptDangDO;
import com.bootdo.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:35:39
 */
@Mapper
public interface DeptDangDao {

	DeptDangDO get(Long deptId);
	
	List<DeptDangDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DeptDangDO dept);
	
	int update(DeptDangDO dept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);
	
	Long[] listParentDept();
	
	int getDeptUserNumber(Long deptId);
}
