package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
public class CheckDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//考核主键
	private Long checkId;
	//user_id
	private Long userId;
	//考核时间
	private String checkTime;
	//考核详情以及备注
	private String checkWord;
	//考核文件或者图片
	private String checkFileId;
	
	//考核年度
	private String checkYear;
	//考核等级
	private String checkGlass;	

	
	public String getCheckYear() {
		return checkYear;
	}
	public void setCheckYear(String checkYear) {
		this.checkYear = checkYear;
	}
	public String getCheckGlass() {
		return checkGlass;
	}
	public void setCheckGlass(String checkGlass) {
		this.checkGlass = checkGlass;
	}
	/**
	 * 设置：考核主键
	 */
	public void setCheckId(Long checkId) {
		this.checkId = checkId;
	}
	/**
	 * 获取：考核主键
	 */
	public Long getCheckId() {
		return checkId;
	}
	/**
	 * 设置：user_id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：user_id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：考核时间
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	/**
	 * 获取：考核时间
	 */
	public String getCheckTime() {
		return checkTime;
	}
	/**
	 * 设置：考核详情以及备注
	 */
	public void setCheckWord(String checkWord) {
		this.checkWord = checkWord;
	}
	/**
	 * 获取：考核详情以及备注
	 */
	public String getCheckWord() {
		return checkWord;
	}
	/**
	 * 设置：考核文件或者图片
	 */
	public void setCheckFileId(String checkFileId) {
		this.checkFileId = checkFileId;
	}
	/**
	 * 获取：考核文件或者图片
	 */
	public String getCheckFileId() {
		return checkFileId;
	}
}
