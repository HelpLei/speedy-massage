package com.bootdo.system.service.impl;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import com.bootdo.system.dao.DeptInstitutionDao;
import com.bootdo.system.domain.DeptInstitutionDO;
import com.bootdo.system.service.DeptInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DeptInstitutionServiceImpl implements DeptInstitutionService {
	@Autowired
	private DeptInstitutionDao deptInstitutionDao;

	@Override
	public DeptInstitutionDO get(Long deptId) {
		return deptInstitutionDao.get(deptId);
	}

	@Override
	public List<DeptInstitutionDO> list(Map<String, Object> map) {
		return deptInstitutionDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return deptInstitutionDao.count(map);
	}

	@Override
	public int save(DeptInstitutionDO sysDept) {
		return deptInstitutionDao.save(sysDept);
	}

	@Override
	public int update(DeptInstitutionDO sysDept) {
		return deptInstitutionDao.update(sysDept);
	}

	@Override
	public int remove(Long deptId) {
		return deptInstitutionDao.remove(deptId);
	}

	@Override
	public int batchRemove(Long[] deptIds) {
		return deptInstitutionDao.batchRemove(deptIds);
	}

	@Override
	public Tree<DeptInstitutionDO> getTree() {
		List<Tree<DeptInstitutionDO>> trees = new ArrayList<Tree<DeptInstitutionDO>>();
		List<DeptInstitutionDO> sysDepts = deptInstitutionDao.list(new HashMap<String, Object>(16));
		for (DeptInstitutionDO sysDept : sysDepts) {
			Tree<DeptInstitutionDO> tree = new Tree<DeptInstitutionDO>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptInstitutionDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public Tree<DeptInstitutionDO> getTree(Integer isDept) {
		List<Tree<DeptInstitutionDO>> trees = new ArrayList<Tree<DeptInstitutionDO>>();
		Map maps = new HashMap<String, Object>(16);
		maps.put("isDept",isDept);
		List<DeptInstitutionDO> sysDepts = deptInstitutionDao.list(maps);
		for (DeptInstitutionDO sysDept : sysDepts) {
			Tree<DeptInstitutionDO> tree = new Tree<DeptInstitutionDO>();
			tree.setId(sysDept.getDeptId().toString());
			tree.setParentId(sysDept.getParentId().toString());
			tree.setText(sysDept.getName());
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptInstitutionDO> t = BuildTree.build(trees);
		return t;
	}

	@Override
	public boolean checkDeptHasUser(Long deptId) {
		// TODO Auto-generated method stub
		//查询部门以及此部门的下级部门
		int result = deptInstitutionDao.getDeptUserNumber(deptId);
		return result == 0 ? true : false;
	}

	@Override
	public List<Long> listChildrenIds(Long parentId) {
		List<DeptInstitutionDO> deptDOS = list(null);
		return treeMenuList(deptDOS, parentId);
	}

	List<Long> treeMenuList(List<DeptInstitutionDO> menuList, long pid) {
		List<Long> childIds = new ArrayList<>();
		for (DeptInstitutionDO mu : menuList) {
			//遍历出父id等于参数的id，add进子节点集合
			if (mu.getParentId() == pid) {
				//递归遍历下一级
				treeMenuList(menuList, mu.getDeptId());
				childIds.add(mu.getDeptId());
			}
		}
		return childIds;
	}


}
