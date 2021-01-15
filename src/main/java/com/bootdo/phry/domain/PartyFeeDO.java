package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-04 16:47:00
 */
public class PartyFeeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//人员id
	private Long userId;
	//人员姓名
	private String username;
	//性别1：男0：女
	private Long sex;
	//身份证号
	private String idCard;
	//党费金额
	private String money;
	//缴纳党费时间
	private Date payTime;

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
	 * 设置：党费金额
	 */
	public void setMoney(String money) {
		this.money = money;
	}
	/**
	 * 获取：党费金额
	 */
	public String getMoney() {
		return money;
	}
	/**
	 * 设置：缴纳党费时间
	 */
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：缴纳党费时间
	 */
	public Date getPayTime() {
		return payTime;
	}
}
