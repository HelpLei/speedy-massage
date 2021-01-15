package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学历代码表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 09:28:39
 */
public class EducationCodeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long educationCodeId;
	private Long parentId;
	//学历代码
	private String educationCode;
	//学历名称
	private String educationCodeName;
	//学历年限
	private String educationYear;
	//状态 0:禁用，1:正常
	private Integer status;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setEducationCodeId(Long educationCodeId) {
		this.educationCodeId = educationCodeId;
	}
	/**
	 * 获取：
	 */
	public Long getEducationCodeId() {
		return educationCodeId;
	}
	/**
	 * 设置：学历代码
	 */
	public void setEducationCode(String educationCode) {
		this.educationCode = educationCode;
	}
	/**
	 * 获取：学历代码
	 */
	public String getEducationCode() {
		return educationCode;
	}
	/**
	 * 设置：手机号
	 */
	public void setEducationCodeName(String educationCodeName) {
		this.educationCodeName = educationCodeName;
	}
	/**
	 * 获取：手机号
	 */
	public String getEducationCodeName() {
		return educationCodeName;
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getEducationYear() {
		return educationYear;
	}

	public void setEducationYear(String educationYear) {
		this.educationYear = educationYear;
	}
}
