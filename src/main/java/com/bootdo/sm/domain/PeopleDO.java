package com.bootdo.sm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 被服务人员姓名
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public class PeopleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//人员id
	private Integer id;
	//人员姓名
	private String name;
	//昵称
	private String nickname;
	//头像
	private Integer photo;
	//身份证
	private String card;
	//手机号
	private String phone;
	//生日
	private String birthday;
	//个人地址
	private String address;
	//消费次数
	private Integer consumeCount;
	//消费金额
	private BigDecimal consumePrice;
	//消费积分
	private Integer consumeIntegral;

	/**
	 * 设置：人员id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：人员id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：人员姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：人员姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：头像
	 */
	public void setPhoto(Integer photo) {
		this.photo = photo;
	}
	/**
	 * 获取：头像
	 */
	public Integer getPhoto() {
		return photo;
	}
	/**
	 * 设置：身份证
	 */
	public void setCard(String card) {
		this.card = card;
	}
	/**
	 * 获取：身份证
	 */
	public String getCard() {
		return card;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * 设置：个人地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：个人地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：消费次数
	 */
	public void setConsumeCount(Integer consumeCount) {
		this.consumeCount = consumeCount;
	}
	/**
	 * 获取：消费次数
	 */
	public Integer getConsumeCount() {
		return consumeCount;
	}
	/**
	 * 设置：消费金额
	 */
	public void setConsumePrice(BigDecimal consumePrice) {
		this.consumePrice = consumePrice;
	}
	/**
	 * 获取：消费金额
	 */
	public BigDecimal getConsumePrice() {
		return consumePrice;
	}
	/**
	 * 设置：消费积分
	 */
	public void setConsumeIntegral(Integer consumeIntegral) {
		this.consumeIntegral = consumeIntegral;
	}
	/**
	 * 获取：消费积分
	 */
	public Integer getConsumeIntegral() {
		return consumeIntegral;
	}
}
