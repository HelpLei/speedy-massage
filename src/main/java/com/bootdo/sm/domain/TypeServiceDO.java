package com.bootdo.sm.domain;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 服务类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public class TypeServiceDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//类型ID
	private Integer id;
	//类型名称
	private String name;
	//类型时间
	private Integer typeTime;
	//类型详情
	private String nameDetail;
	//价格
	private BigDecimal price;
	//已预约总数量
	private Integer serviceCountf;
	//针对部位
	private String forParts;
	//调理疾病
	private String regulateContent;
	//服务内容
	private String serviceContent;
	//预约须知
	private String bookingInformation;
	//禁忌提示
	private String tabooPrompt;
	//现在状态0为启用，1为关闭
	private Integer type;
	//创建人的ID
	private Integer creatId;
	//创建人员
	private String creatName;
	//创建的时间
	private Date creatTime;
	//备注
	private String remark;

	/**
	 * 设置：类型ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：类型ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：类型名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：类型名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：类型时间
	 */
	public void setTypeTime(Integer typeTime) {
		this.typeTime = typeTime;
	}
	/**
	 * 获取：类型时间
	 */
	public Integer getTypeTime() {
		return typeTime;
	}
	/**
	 * 设置：类型详情
	 */
	public void setNameDetail(String nameDetail) {
		this.nameDetail = nameDetail;
	}
	/**
	 * 获取：类型详情
	 */
	public String getNameDetail() {
		return nameDetail;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：已预约总数量
	 */
	public void setServiceCountf(Integer serviceCountf) {
		this.serviceCountf = serviceCountf;
	}
	/**
	 * 获取：已预约总数量
	 */
	public Integer getServiceCountf() {
		return serviceCountf;
	}
	/**
	 * 设置：针对部位
	 */
	public void setForParts(String forParts) {
		this.forParts = forParts;
	}
	/**
	 * 获取：针对部位
	 */
	public String getForParts() {
		return forParts;
	}
	/**
	 * 设置：调理疾病
	 */
	public void setRegulateContent(String regulateContent) {
		this.regulateContent = regulateContent;
	}
	/**
	 * 获取：调理疾病
	 */
	public String getRegulateContent() {
		return regulateContent;
	}
	/**
	 * 设置：服务内容
	 */
	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}
	/**
	 * 获取：服务内容
	 */
	public String getServiceContent() {
		return serviceContent;
	}
	/**
	 * 设置：预约须知
	 */
	public void setBookingInformation(String bookingInformation) {
		this.bookingInformation = bookingInformation;
	}
	/**
	 * 获取：预约须知
	 */
	public String getBookingInformation() {
		return bookingInformation;
	}
	/**
	 * 设置：禁忌提示
	 */
	public void setTabooPrompt(String tabooPrompt) {
		this.tabooPrompt = tabooPrompt;
	}
	/**
	 * 获取：禁忌提示
	 */
	public String getTabooPrompt() {
		return tabooPrompt;
	}
	/**
	 * 设置：现在状态0为启用，1为关闭
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：现在状态0为启用，1为关闭
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：创建人的ID
	 */
	public void setCreatId(Integer creatId) {
		this.creatId = creatId;
	}
	/**
	 * 获取：创建人的ID
	 */
	public Integer getCreatId() {
		return creatId;
	}
	/**
	 * 设置：创建人员
	 */
	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}
	/**
	 * 获取：创建人员
	 */
	public String getCreatName() {
		return creatName;
	}
	/**
	 * 设置：创建的时间
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	/**
	 * 获取：创建的时间
	 */
	public Date getCreatTime() {
		return creatTime;
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
