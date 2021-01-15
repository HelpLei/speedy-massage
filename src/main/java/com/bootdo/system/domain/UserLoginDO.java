package com.bootdo.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 登录表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:26
 */
@Data
public class UserLoginDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Long userId;
	//姓名
	private String username;
	//手机号
	private String mobile;
	//密码
	private String password;
	//部门Id
	private Long deptId;
	private String deptName;
	//状态 0:禁用，1:正常
	private Integer status;
	//创建用户id
	private Long userIdCreate;

	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;
	//角色
	private List<Long> roleIds;

	private Integer missNumber;

	private Date missTime;

	private Date allowTime;
}
