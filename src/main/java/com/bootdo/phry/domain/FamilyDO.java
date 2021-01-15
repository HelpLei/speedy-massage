package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
public class FamilyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long familyId;
	//userId
	private Long userId;
	//称谓
	private String familyAppellation;
	//姓名
	private String familyName;
	//出生日期
	private String birthTime;
	//政治面貌
	private String politicsFace;
	//工作单位以及职务
	private String workUnits;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;

	/**
	 * 设置：主键Id
	 */
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getFamilyId() {
		return familyId;
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
	 * 设置：称谓
	 */
	public void setFamilyAppellation(String familyAppellation) {
		this.familyAppellation = familyAppellation;
	}
	/**
	 * 获取：称谓
	 */
	public String getFamilyAppellation() {
		return familyAppellation;
	}
	/**
	 * 设置：姓名
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	/**
	 * 获取：姓名
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * 设置：出生日期
	 */
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}
	/**
	 * 获取：出生日期
	 */
	public String getBirthTime() {
		return birthTime;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setPoliticsFace(String politicsFace) {
		this.politicsFace = politicsFace;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getPoliticsFace() {
		return politicsFace;
	}
	/**
	 * 设置：工作单位以及职务
	 */
	public void setWorkUnits(String workUnits) {
		this.workUnits = workUnits;
	}
	/**
	 * 获取：工作单位以及职务
	 */
	public String getWorkUnits() {
		return workUnits;
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
