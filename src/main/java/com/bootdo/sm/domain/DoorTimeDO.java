package com.bootdo.sm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public class DoorTimeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//时间段ID
	private Integer id;
	//预约人员ID
	private Integer appointmentPersonId;
	//预约人员
	private String appointmentPerson;
	//预约时间
	private Date appointmentTime;
	//预约类型
	private Integer appointmentService;

	/**
	 * 设置：时间段ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：时间段ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：预约人员ID
	 */
	public void setAppointmentPersonId(Integer appointmentPersonId) {
		this.appointmentPersonId = appointmentPersonId;
	}
	/**
	 * 获取：预约人员ID
	 */
	public Integer getAppointmentPersonId() {
		return appointmentPersonId;
	}
	/**
	 * 设置：预约人员
	 */
	public void setAppointmentPerson(String appointmentPerson) {
		this.appointmentPerson = appointmentPerson;
	}
	/**
	 * 获取：预约人员
	 */
	public String getAppointmentPerson() {
		return appointmentPerson;
	}
	/**
	 * 设置：预约时间
	 */
	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	/**
	 * 设置：预约类型
	 */
	public void setAppointmentService(Integer appointmentService) {
		this.appointmentService = appointmentService;
	}
	/**
	 * 获取：预约类型
	 */
	public Integer getAppointmentService() {
		return appointmentService;
	}
}
