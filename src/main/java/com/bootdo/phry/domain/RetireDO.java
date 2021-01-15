package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 缴纳党费信息录入
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 10:06:33
 */
public class RetireDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//人员id
	private Long userId;
	//人员姓名
	private String username;
	//部门
	private String dept;
	//性别1：男0：女
	private Long sex;
	//身份证号
	private String idCard;
	//出生日期
	private String birth;
	//年龄
	private Integer age;
	//退休天数
	private Integer retireDays;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：人员id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：人员id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：人员姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：人员姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：部门
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * 获取：部门
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * 设置：性别1：男0：女
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别1：男0：女
	 */
	public Long getSex() {
		return sex;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	/**
	 * 获取：出生日期
	 */
	public String getBirth() {
		return birth;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：退休天数
	 */
	public void setRetireDays(Integer retireDays) {
		this.retireDays = retireDays;
	}
	/**
	 * 获取：退休天数
	 */
	public Integer getRetireDays() {
		return retireDays;
	}
}
