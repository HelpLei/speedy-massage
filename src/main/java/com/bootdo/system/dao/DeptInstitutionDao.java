package com.bootdo.system.dao;

import com.bootdo.system.domain.DeptInstitutionDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 机构管理
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:20
 */
@Mapper
public interface DeptInstitutionDao {

	DeptInstitutionDO get(Long deptId);

	List<DeptInstitutionDO> list(Map<String,Object> map);

	int count(Map<String,Object> map);

	int save(DeptInstitutionDO dept);

	int update(DeptInstitutionDO dept);

	int remove(Long deptId);

	int batchRemove(Long[] deptIds);

	Long[] listParentDept();

	int getDeptUserNumber(Long deptId);
}
