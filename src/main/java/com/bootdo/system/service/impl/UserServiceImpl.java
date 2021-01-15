package com.bootdo.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.*;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import com.bootdo.system.dao.*;
import com.bootdo.system.domain.*;
import com.bootdo.system.service.DeptService;
import com.bootdo.system.vo.UserLoginVO;
import com.bootdo.system.vo.UserVO;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootdo.common.domain.Tree;
import com.bootdo.system.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserLoginDao userMapper;
    @Autowired
    UserRoleDao userRoleMapper;
    @Autowired
    DeptInstitutionDao deptMapper;
    @Autowired
    private FileService sysFileService;
    @Autowired
    private BootdoConfig bootdoConfig;
    @Autowired
    DeptService deptService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
//    @Cacheable(value = "user",key = "#id")
    public UserLoginDO get(Long id) {
        List<Long> roleIds = userRoleMapper.listRoleId(id);
        UserLoginDO user = userMapper.get(id);
        user.setDeptName(deptMapper.get(user.getDeptId()).getName());
        user.setRoleIds(roleIds);
        return user;
    }

    @Override
    public List<UserLoginDO> list(Map<String, Object> map) {
        String deptId = map.get("deptId").toString();
        if (StringUtils.isNotBlank(deptId)) {
            Long deptIdl = Long.valueOf(deptId);
            List<Long> childIds = deptService.listChildrenIds(deptIdl);
            childIds.add(deptIdl);
            map.put("deptId", null);
            map.put("deptIds",childIds);
        }
        return userMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMapper.count(map);
    }

    @Transactional
    @Override
    public int save(UserLoginDO user) {
        int count = userMapper.save(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return count;
    }

    @Override
    public int update(UserLoginDO user) {
        int r = userMapper.update(user);
        Long userId = user.getUserId();
        List<Long> roles = user.getRoleIds();
        userRoleMapper.removeByUserId(userId);
        List<UserRoleDO> list = new ArrayList<>();
        for (Long roleId : roles) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            list.add(ur);
        }
        if (list.size() > 0) {
            userRoleMapper.batchSave(list);
        }
        return r;
    }

    //    @CacheEvict(value = "user")
    @Override
    public int remove(Long userId) {
        userRoleMapper.removeByUserId(userId);
        return userMapper.remove(userId);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = userMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public Set<String> listRoles(Long userId) {
        return null;
    }

    @Override
    public List<UserLoginDO> getById(Map<String,Object> map){return userMapper.getById(map);}

    @Override
    public int selectByNamePassword(Map<String,Object> map){return  userMapper.selectByNamePassword(map);}

    @Override
    public int update1(UserLoginDO user) {
        return userMapper.update1(user);
    }

    @Override
    public int resetPwd(UserLoginVO userVO, UserLoginDO userDO) throws Exception {
        if (Objects.equals(userVO.getUserDO().getUserId(), userDO.getUserId())) {
            if (Objects.equals(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdOld()), userDO.getPassword())) {
                userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
                return userMapper.update(userDO);
            } else {
                throw new Exception("输入的旧密码有误！");
            }
        } else {
            throw new Exception("你修改的不是你登录的账号！");
        }
    }

    @Override
    public int adminResetPwd(UserLoginVO userVO) throws Exception {
        UserLoginDO userDO = get(userVO.getUserDO().getUserId());
        if ("admin".equals(userDO.getUsername())) {
            throw new Exception("超级管理员的账号不允许直接重置！");
        }
        userDO.setPassword(MD5Utils.encrypt(userDO.getUsername(), userVO.getPwdNew()));
        return userMapper.update(userDO);


    }

    @Transactional
    @Override
    public int batchremove(Long[] userIds) {
        int count = userMapper.batchRemove(userIds);
        userRoleMapper.batchRemoveByUserId(userIds);
        return count;
    }

    @Override
    public Tree<DeptInstitutionDO> getTree() {
        List<Tree<DeptInstitutionDO>> trees = new ArrayList<Tree<DeptInstitutionDO>>();
        List<DeptInstitutionDO> depts = deptMapper.list(new HashMap<String, Object>(16));
        Long[] pDepts = deptMapper.listParentDept();
        Long[] uDepts = userMapper.listAllDept();
        Long[] allDepts = (Long[]) ArrayUtils.addAll(pDepts, uDepts);
        for (DeptInstitutionDO dept : depts) {
            if (!ArrayUtils.contains(allDepts, dept.getDeptId())) {
                continue;
            }
            Tree<DeptInstitutionDO> tree = new Tree<DeptInstitutionDO>();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setText(dept.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", false);
            state.put("mType", "dept");
            tree.setState(state);
            trees.add(tree);
        }
        List<UserLoginDO> users = userMapper.list(new HashMap<String, Object>(16));
        for (UserLoginDO user : users) {
            Tree<DeptInstitutionDO> tree = new Tree<DeptInstitutionDO>();
            tree.setId(user.getUserId().toString());
            tree.setParentId(user.getDeptId().toString());
            tree.setText(user.getUsername());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            state.put("mType", "user");
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DeptInstitutionDO> t = BuildTree.build(trees);
        return t;
    }

    @Override
    public int updatePersonal(UserLoginDO userDO) {
        return userMapper.update(userDO);
    }
}
