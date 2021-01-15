package com.bootdo.phry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.BuildTree;
import com.bootdo.phry.dao.DeptDangDao;
import com.bootdo.phry.domain.DeptDangDO;
import com.bootdo.phry.service.DeptDangService;
import com.bootdo.system.dao.DeptDao;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.service.DeptService;


@Service
public class DeptDangServiceImpl implements DeptDangService {
    @Autowired
    private DeptDangDao sysDeptDangMapper;

    @Override
    public DeptDangDO get(Long deptId) {
        return sysDeptDangMapper.get(deptId);
    }

    @Override
    public List<DeptDangDO> list(Map<String, Object> map) {
        return sysDeptDangMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return sysDeptDangMapper.count(map);
    }

    @Override
    public int save(DeptDangDO sysDept) {
        return sysDeptDangMapper.save(sysDept);
    }

    @Override
    public int update(DeptDangDO sysDept) {
        return sysDeptDangMapper.update(sysDept);
    }

    @Override
    public int remove(Long deptId) {
        return sysDeptDangMapper.remove(deptId);
    }

    @Override
    public int batchRemove(Long[] deptIds) {
        return sysDeptDangMapper.batchRemove(deptIds);
    }

    @Override
    public Tree<DeptDangDO> getTree() {
        List<Tree<DeptDangDO>> trees = new ArrayList<Tree<DeptDangDO>>();
        List<DeptDangDO> sysDepts = sysDeptDangMapper.list(new HashMap<String, Object>(16));
        for (DeptDangDO sysDept : sysDepts) {
            Tree<DeptDangDO> tree = new Tree<DeptDangDO>();
            tree.setId(sysDept.getDeptId().toString());
            tree.setParentId(sysDept.getParentId().toString());
            tree.setText(sysDept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", false);
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptDangDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public boolean checkDeptHasUser(Long deptId) {
        // TODO Auto-generated method stub
        //查询部门以及此部门的下级部门
        int result = sysDeptDangMapper.getDeptUserNumber(deptId);
        return result == 0 ? true : false;
    }

    @Override
    public List<Long> listChildrenIds(Long parentId) {
        List<DeptDangDO> deptDOS = list(null);
        return treeMenuList(deptDOS, parentId);
    }

    List<Long> treeMenuList(List<DeptDangDO> menuList, long pid) {
        List<Long> childIds = new ArrayList<>();
        for (DeptDangDO mu : menuList) {
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
