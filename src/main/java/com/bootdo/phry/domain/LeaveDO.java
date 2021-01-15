package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 请假表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 10:23:55
 */
public class LeaveDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//请假ID
	private Integer id;
	//合同表ID
	private Integer pactId;
	//姓名
	private String name;
	//部门
	private String department;
	//职位
	private String post;
	//请假开始时间
	private String leaveTime;
	//请假到什么时候
	private String endTime;
	//请假天数
	private String leaveDate;
	//请假原因
	private String leaveReason;

	/**
	 * 设置：请假ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：请假ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：合同表ID
	 */
	public void setPactId(Integer pactId) {
		this.pactId = pactId;
	}
	/**
	 * 获取：合同表ID
	 */
	public Integer getPactId() {
		return pactId;
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
	 * 设置：请假开始时间
	 */
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	/**
	 * 获取：请假开始时间
	 */
	public String getLeaveTime() {
		return leaveTime;
	}
	/**
	 * 设置：请假到什么时候
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：请假到什么时候
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：请假天数
	 */
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	/**
	 * 获取：请假天数
	 */
	public String getLeaveDate() {
		return leaveDate;
	}
	/**
	 * 设置：请假原因
	 */
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	/**
	 * 获取：请假原因
	 */
	public String getLeaveReason() {
		return leaveReason;
	}
}
