package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 党籍表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
public class OnlyPartyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long partyId;
	//userId
	private Long userId;
	//入党时间
	private Date partyEnterTime;
	//任职文号（图片）
	private String partyFileId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;
	//姓名
	private String name;
	//身份证
	private String card;
	//照片
	private Long phoneId;
	//手机号
    private String shouji;
	
	// 部门
    private Long deptId;
    private String deptName;
	
	
	
	public String getShouji() {
		return shouji;
	}
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Long getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 设置：主键Id
	 */
	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getPartyId() {
		return partyId;
	}
	/**
	 * 设置：userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：入党时间
	 */
	public void setPartyEnterTime(Date partyEnterTime) {
		this.partyEnterTime = partyEnterTime;
	}
	/**
	 * 获取：入党时间
	 */
	public Date getPartyEnterTime() {
		return partyEnterTime;
	}
	/**
	 * 设置：任职文号（图片）
	 */
	public void setPartyFileId(String partyFileId) {
		this.partyFileId = partyFileId;
	}
	/**
	 * 获取：任职文号（图片）
	 */
	public String getPartyFileId() {
		return partyFileId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
}
