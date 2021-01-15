package com.bootdo.phry.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.phry.domain.DeptDangDO;
import com.bootdo.system.domain.DeptDO;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-27 14:28:36
 */
public interface DeptDangService {
	
	DeptDangDO get(Long deptId);
	
	List<DeptDangDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDangDO sysDept);
	
	int update(DeptDangDO sysDept);
	
	int remove(Long deptId);
	
	int batchRemove(Long[] deptIds);

	Tree<DeptDangDO> getTree();
	
	boolean checkDeptHasUser(Long deptId);

	List<Long> listChildrenIds(Long parentId);
}
