package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 15:53:38
 */
public class PactDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//合同ID
	private Integer id;
	//签订时间
	private String dateSigning;
	//到期时间
	private String expirationTime;
	//人员表ID
	private Integer personnelId;
	//试用期时间
	private String probationPeriod;
	//姓名
	private String name;
	//出生日期
	private String dateBirth;
	//部门
	private String department;
	//职位
	private String post;
	//在职状态(1为在职,2为提前离职，3已续签合同，4正常离职)
	private Integer workingState;
	//合同到期具体时间
	private Integer expirationDate;
	//试用期到期具体时间
	private Integer probationDate;
	//退休时间
	private Integer retireDate;
	//1为男，0为女
	private Integer sex;
	//备注
	private String pactRemark;
	//退休状态（1为未退休，2为退休）
	private Integer retirement;

	//图片ID
		private String fileId;
		
		//离职时间
		private String resignationTime;
		//转岗时间
		private String transferTime;
		
		
		
		
	public String getResignationTime() {
			return resignationTime;
		}
		public void setResignationTime(String resignationTime) {
			this.resignationTime = resignationTime;
		}
		public String getTransferTime() {
			return transferTime;
		}
		public void setTransferTime(String transferTime) {
			this.transferTime = transferTime;
		}
	public String getFileId() {
			return fileId;
		}
		public void setFileId(String fileId) {
			this.fileId = fileId;
		}
	/**
	 * 设置：合同ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：合同ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：签订时间
	 */
	public void setDateSigning(String dateSigning) {
		this.dateSigning = dateSigning;
	}
	/**
	 * 获取：签订时间
	 */
	public String getDateSigning() {
		return dateSigning;
	}
	/**
	 * 设置：到期时间
	 */
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	/**
	 * 获取：到期时间
	 */
	public String getExpirationTime() {
		return expirationTime;
	}
	/**
	 * 设置：人员表ID
	 */
	public void setPersonnelId(Integer personnelId) {
		this.personnelId = personnelId;
	}
	/**
	 * 获取：人员表ID
	 */
	public Integer getPersonnelId() {
		return personnelId;
	}
	/**
	 * 设置：试用期时间
	 */
	public void setProbationPeriod(String probationPeriod) {
		this.probationPeriod = probationPeriod;
	}
	/**
	 * 获取：试用期时间
	 */
	public String getProbationPeriod() {
		return probationPeriod;
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
	 * 设置：出生日期
	 */
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	/**
	 * 获取：出生日期
	 */
	public String getDateBirth() {
		return dateBirth;
	}
	/**
	 * 设置：部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 获取：部门
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * 设置：职位
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * 获取：职位
	 */
	public String getPost() {
		return post;
	}
	/**
	 * 设置：在职状态(1为在职,2为提前离职，3已续签合同，4正常离职)
	 */
	public void setWorkingState(Integer workingState) {
		this.workingState = workingState;
	}
	/**
	 * 获取：在职状态(1为在职,2为提前离职，3已续签合同，4正常离职)
	 */
	public Integer getWorkingState() {
		return workingState;
	}
	/**
	 * 设置：合同到期具体时间
	 */
	public void setExpirationDate(Integer expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * 获取：合同到期具体时间
	 */
	public Integer getExpirationDate() {
		return expirationDate;
	}
	/**
	 * 设置：试用期到期具体时间
	 */
	public void setProbationDate(Integer probationDate) {
		this.probationDate = probationDate;
	}
	/**
	 * 获取：试用期到期具体时间
	 */
	public Integer getProbationDate() {
		return probationDate;
	}
	/**
	 * 设置：退休时间
	 */
	public void setRetireDate(Integer retireDate) {
		this.retireDate = retireDate;
	}
	/**
	 * 获取：退休时间
	 */
	public Integer getRetireDate() {
		return retireDate;
	}
	/**
	 * 设置：1为男，0为女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：1为男，0为女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：备注
	 */
	public void setPactRemark(String pactRemark) {
		this.pactRemark = pactRemark;
	}
	/**
	 * 获取：备注
	 */
	public String getPactRemark() {
		return pactRemark;
	}
	/**
	 * 设置：退休状态（1为未退休，2为退休）
	 */
	public void setRetirement(Integer retirement) {
		this.retirement = retirement;
	}
	/**
	 * 获取：退休状态（1为未退休，2为退休）
	 */
	public Integer getRetirement() {
		return retirement;
	}
}
