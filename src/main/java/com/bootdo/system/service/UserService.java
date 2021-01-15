package com.bootdo.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bootdo.system.domain.DeptInstitutionDO;
import com.bootdo.system.domain.UserLoginDO;
import com.bootdo.system.vo.UserLoginVO;
import org.springframework.stereotype.Service;

import com.bootdo.common.domain.Tree;
import com.bootdo.system.domain.DeptDO;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UserService {
	UserLoginDO get(Long id);

	List<UserLoginDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserLoginDO user);

	int update(UserLoginDO user);

	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	List<UserLoginDO> getById(Map<String,Object> map);

	int selectByNamePassword(Map<String,Object> map);

	int update1(UserLoginDO user);

	int resetPwd(UserLoginVO userVO, UserLoginDO userDO) throws Exception;
	int adminResetPwd(UserLoginVO userVO) throws Exception;
	Tree<DeptInstitutionDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserLoginDO userDO);
}
