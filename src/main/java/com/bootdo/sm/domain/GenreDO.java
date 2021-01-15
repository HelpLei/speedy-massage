package com.bootdo.sm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 个人类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
public class GenreDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//个人类型
	private String name;
	//0为显示，1为删除
	private Integer type;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：个人类型
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：个人类型
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：0为显示，1为删除
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：0为显示，1为删除
	 */
	public Integer getType() {
		return type;
	}
}
