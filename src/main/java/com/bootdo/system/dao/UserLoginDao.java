package com.bootdo.system.dao;

import com.bootdo.system.domain.UserLoginDO;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;

/**
 * 登录表
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:26
 */
@Mapper
public interface UserLoginDao {

	UserLoginDO get(Long userId);

	List<UserLoginDO> list(Map<String,Object> map);

	int count(Map<String,Object> map);

	int save(UserLoginDO user);

	int update(UserLoginDO user);

	int remove(Long userId);

	int batchRemove(Long[] userIds);

	Long[] listAllDept();

	List<UserLoginDO> getById(Map<String,Object> map);

	int selectByNamePassword(Map<String,Object> map);

	int update1(UserLoginDO user);
}
