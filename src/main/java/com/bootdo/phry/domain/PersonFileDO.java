package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2020-04-14 11:36:29
 */
public class PersonFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//个人文件的Id
	private Integer id;
	//人员ID
	private Long userId;
	//姓名
	private String username;
	//身份证
	private String idCard;
	//文件名称
	private String fileName;
	//文件Id
	private String fileId;
	//报告时间
	private String baogaoTime;
	//年度时间
	private String year;
	//新增时间
	private String addTime;
	//创建人员id
	private String creatId;
	//创建姓名
	private String creatName;
	//状态0为普通文件，1为个人事项报告表
	private Integer style;

	/**
	 * 设置：个人文件的Id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：个人文件的Id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：人员ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：人员ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：身份证
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件Id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：文件Id
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：报告时间
	 */
	public void setBaogaoTime(String baogaoTime) {
		this.baogaoTime = baogaoTime;
	}
	/**
	 * 获取：报告时间
	 */
	public String getBaogaoTime() {
		return baogaoTime;
	}
	/**
	 * 设置：年度时间
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年度时间
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：新增时间
	 */
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：新增时间
	 */
	public String getAddTime() {
		return addTime;
	}
	/**
	 * 设置：创建人员id
	 */
	public void setCreatId(String creatId) {
		this.creatId = creatId;
	}
	/**
	 * 获取：创建人员id
	 */
	public String getCreatId() {
		return creatId;
	}
	/**
	 * 设置：创建姓名
	 */
	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}
	/**
	 * 获取：创建姓名
	 */
	public String getCreatName() {
		return creatName;
	}
	/**
	 * 设置：状态0为普通文件，1为个人事项报告表
	 */
	public void setStyle(Integer style) {
		this.style = style;
	}
	/**
	 * 获取：状态0为普通文件，1为个人事项报告表
	 */
	public Integer getStyle() {
		return style;
	}
}
