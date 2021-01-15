package com.bootdo.sm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 技师人员
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public class TechnicianDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//技师ID
	private Integer id;
	//技师会的技能
	private String typeId;
	//姓名
	private String name;
	//头像上传
	private Integer namePicture;
	//身份证
	private String card;
	//年龄
	private Integer age;
	//手机号
	private String phone;
	//地址
	private String address;
	//人员详情
	private String personDetail;
	//个人类型
	private Integer genre;
	//经济联系人姓名
	private String urgencyName;
	//紧急人关系
	private String urgencyRelation;
	//紧急联系人电话
	private String urgencyPhone;
	//加入时间
	private Date joinDate;
	//离职时间
	private Date outDate;
	//订单数
	private Integer numberOrders;
	//订单实际所获得的价格
	private BigDecimal numberSurePrice;
	//订单价格
	private BigDecimal numberPrice;
	//评价平均分数
	private BigDecimal evaluationScore;
	//证书名称
	private String credentialsName;
	//证书上传id
	private String credentialsFile;
	//证书名称
	private String credentialsNameTwo;
	//证书上传id
	private String credentialsFileTwo;
	//证书名称
	private String credentialsNameThree;
	//证书上传id
	private String credentialsFileThree;
	//证书名称
	private String credentialsNameFour;
	//证书上传id
	private String credentialsFileFour;
	//创建人员id
	private Integer creatId;
	//创建人员姓名
	private String creatName;
	//创建时间
	private Date creatTime;
	//0为正常，1为删除
	private Integer type;
	//备注
	private String remark;

	/**
	 * 设置：技师ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：技师ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：技师会的技能
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：技师会的技能
	 */
	public String getTypeId() {
		return typeId;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：头像上传
	 */
	public void setNamePicture(Integer namePicture) {
		this.namePicture = namePicture;
	}
	/**
	 * 获取：头像上传
	 */
	public Integer getNamePicture() {
		return namePicture;
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
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：人员详情
	 */
	public void setPersonDetail(String personDetail) {
		this.personDetail = personDetail;
	}
	/**
	 * 获取：人员详情
	 */
	public String getPersonDetail() {
		return personDetail;
	}
	/**
	 * 设置：个人类型
	 */
	public void setGenre(Integer genre) {
		this.genre = genre;
	}
	/**
	 * 获取：个人类型
	 */
	public Integer getGenre() {
		return genre;
	}
	/**
	 * 设置：经济联系人姓名
	 */
	public void setUrgencyName(String urgencyName) {
		this.urgencyName = urgencyName;
	}
	/**
	 * 获取：经济联系人姓名
	 */
	public String getUrgencyName() {
		return urgencyName;
	}
	/**
	 * 设置：紧急人关系
	 */
	public void setUrgencyRelation(String urgencyRelation) {
		this.urgencyRelation = urgencyRelation;
	}
	/**
	 * 获取：紧急人关系
	 */
	public String getUrgencyRelation() {
		return urgencyRelation;
	}
	/**
	 * 设置：紧急联系人电话
	 */
	public void setUrgencyPhone(String urgencyPhone) {
		this.urgencyPhone = urgencyPhone;
	}
	/**
	 * 获取：紧急联系人电话
	 */
	public String getUrgencyPhone() {
		return urgencyPhone;
	}
	/**
	 * 设置：加入时间
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * 获取：加入时间
	 */
	public Date getJoinDate() {
		return joinDate;
	}
	/**
	 * 设置：离职时间
	 */
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	/**
	 * 获取：离职时间
	 */
	public Date getOutDate() {
		return outDate;
	}
	/**
	 * 设置：订单数
	 */
	public void setNumberOrders(Integer numberOrders) {
		this.numberOrders = numberOrders;
	}
	/**
	 * 获取：订单数
	 */
	public Integer getNumberOrders() {
		return numberOrders;
	}
	/**
	 * 设置：订单实际所获得的价格
	 */
	public void setNumberSurePrice(BigDecimal numberSurePrice) {
		this.numberSurePrice = numberSurePrice;
	}
	/**
	 * 获取：订单实际所获得的价格
	 */
	public BigDecimal getNumberSurePrice() {
		return numberSurePrice;
	}
	/**
	 * 设置：订单价格
	 */
	public void setNumberPrice(BigDecimal numberPrice) {
		this.numberPrice = numberPrice;
	}
	/**
	 * 获取：订单价格
	 */
	public BigDecimal getNumberPrice() {
		return numberPrice;
	}
	/**
	 * 设置：评价平均分数
	 */
	public void setEvaluationScore(BigDecimal evaluationScore) {
		this.evaluationScore = evaluationScore;
	}
	/**
	 * 获取：评价平均分数
	 */
	public BigDecimal getEvaluationScore() {
		return evaluationScore;
	}
	/**
	 * 设置：证书名称
	 */
	public void setCredentialsName(String credentialsName) {
		this.credentialsName = credentialsName;
	}
	/**
	 * 获取：证书名称
	 */
	public String getCredentialsName() {
		return credentialsName;
	}
	/**
	 * 设置：证书上传id
	 */
	public void setCredentialsFile(String credentialsFile) {
		this.credentialsFile = credentialsFile;
	}
	/**
	 * 获取：证书上传id
	 */
	public String getCredentialsFile() {
		return credentialsFile;
	}
	/**
	 * 设置：证书名称
	 */
	public void setCredentialsNameTwo(String credentialsNameTwo) {
		this.credentialsNameTwo = credentialsNameTwo;
	}
	/**
	 * 获取：证书名称
	 */
	public String getCredentialsNameTwo() {
		return credentialsNameTwo;
	}
	/**
	 * 设置：证书上传id
	 */
	public void setCredentialsFileTwo(String credentialsFileTwo) {
		this.credentialsFileTwo = credentialsFileTwo;
	}
	/**
	 * 获取：证书上传id
	 */
	public String getCredentialsFileTwo() {
		return credentialsFileTwo;
	}
	/**
	 * 设置：证书名称
	 */
	public void setCredentialsNameThree(String credentialsNameThree) {
		this.credentialsNameThree = credentialsNameThree;
	}
	/**
	 * 获取：证书名称
	 */
	public String getCredentialsNameThree() {
		return credentialsNameThree;
	}
	/**
	 * 设置：证书上传id
	 */
	public void setCredentialsFileThree(String credentialsFileThree) {
		this.credentialsFileThree = credentialsFileThree;
	}
	/**
	 * 获取：证书上传id
	 */
	public String getCredentialsFileThree() {
		return credentialsFileThree;
	}
	/**
	 * 设置：证书名称
	 */
	public void setCredentialsNameFour(String credentialsNameFour) {
		this.credentialsNameFour = credentialsNameFour;
	}
	/**
	 * 获取：证书名称
	 */
	public String getCredentialsNameFour() {
		return credentialsNameFour;
	}
	/**
	 * 设置：证书上传id
	 */
	public void setCredentialsFileFour(String credentialsFileFour) {
		this.credentialsFileFour = credentialsFileFour;
	}
	/**
	 * 获取：证书上传id
	 */
	public String getCredentialsFileFour() {
		return credentialsFileFour;
	}
	/**
	 * 设置：创建人员id
	 */
	public void setCreatId(Integer creatId) {
		this.creatId = creatId;
	}
	/**
	 * 获取：创建人员id
	 */
	public Integer getCreatId() {
		return creatId;
	}
	/**
	 * 设置：创建人员姓名
	 */
	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}
	/**
	 * 获取：创建人员姓名
	 */
	public String getCreatName() {
		return creatName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatTime() {
		return creatTime;
	}
	/**
	 * 设置：0为正常，1为删除
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：0为正常，1为删除
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
