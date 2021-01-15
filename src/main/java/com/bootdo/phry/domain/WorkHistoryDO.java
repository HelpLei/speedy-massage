package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
public class WorkHistoryDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long workId;
	//userId
	private Long userId;
	//工作经历是否有两年以上1：是 0：否
	private Integer workTime;
	//全称
	private String workAllName;
	//简称
	private String workSimpleName;
	//任职机构
	private String workInstitution;
	//任职名称
	private String workName;
	//职务名称
	private String officeName;
	//成员类别
	private String workCategory;
	//选拔任用方式
	private String selectMethods;
	//任职文号（图片）
	private Long documentFileId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;

	private String workingTime;

	private String leavingTime;

	private int workingYear;

	public int getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(int workingYear) {
		this.workingYear = workingYear;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getLeavingTime() {
		return leavingTime;
	}

	public void setLeavingTime(String leavingTime) {
		this.leavingTime = leavingTime;
	}

	/**
	 * 设置：主键Id
	 */
	public void setWorkId(Long workId) {
		this.workId = workId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getWorkId() {
		return workId;
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
	 * 设置：工作经历是否有两年以上1：是 0：否
	 */
	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
	}
	/**
	 * 获取：工作经历是否有两年以上1：是 0：否
	 */
	public Integer getWorkTime() {
		return workTime;
	}
	/**
	 * 设置：全称
	 */
	public void setWorkAllName(String workAllName) {
		this.workAllName = workAllName;
	}
	/**
	 * 获取：全称
	 */
	public String getWorkAllName() {
		return workAllName;
	}
	/**
	 * 设置：简称
	 */
	public void setWorkSimpleName(String workSimpleName) {
		this.workSimpleName = workSimpleName;
	}
	/**
	 * 获取：简称
	 */
	public String getWorkSimpleName() {
		return workSimpleName;
	}
	/**
	 * 设置：任职机构
	 */
	public void setWorkInstitution(String workInstitution) {
		this.workInstitution = workInstitution;
	}
	/**
	 * 获取：任职机构
	 */
	public String getWorkInstitution() {
		return workInstitution;
	}
	/**
	 * 设置：任职名称
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	/**
	 * 获取：任职名称
	 */
	public String getWorkName() {
		return workName;
	}
	/**
	 * 设置：职务名称
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	/**
	 * 获取：职务名称
	 */
	public String getOfficeName() {
		return officeName;
	}
	/**
	 * 设置：成员类别
	 */
	public void setWorkCategory(String workCategory) {
		this.workCategory = workCategory;
	}
	/**
	 * 获取：成员类别
	 */
	public String getWorkCategory() {
		return workCategory;
	}
	/**
	 * 设置：选拔任用方式
	 */
	public void setSelectMethods(String selectMethods) {
		this.selectMethods = selectMethods;
	}
	/**
	 * 获取：选拔任用方式
	 */
	public String getSelectMethods() {
		return selectMethods;
	}
	/**
	 * 设置：任职文号（图片）
	 */
	public void setDocumentFileId(Long documentFileId) {
		this.documentFileId = documentFileId;
	}
	/**
	 * 获取：任职文号（图片）
	 */
	public Long getDocumentFileId() {
		return documentFileId;
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
