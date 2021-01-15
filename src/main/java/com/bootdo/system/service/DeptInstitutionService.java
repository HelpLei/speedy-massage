package com.bootdo.system.service;

import com.bootdo.common.domain.Tree;
import com.bootdo.system.domain.DeptInstitutionDO;

import java.util.List;
import java.util.Map;

/**
 * 机构管理
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:20
 */
public interface DeptInstitutionService {

	DeptInstitutionDO get(Long deptId);

	List<DeptInstitutionDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(DeptInstitutionDO sysDept);

	int update(DeptInstitutionDO sysDept);

	int remove(Long deptId);

	int batchRemove(Long[] deptIds);

	Tree<DeptInstitutionDO> getTree();

	Tree<DeptInstitutionDO> getTree(Integer isDept);

	boolean checkDeptHasUser(Long deptId);

	List<Long> listChildrenIds(Long parentId);


}
