package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 缴纳党费信息录入
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 10:06:33
 */
@Data
public class RetireDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//人员id
	private Long userId;
	//人员姓名
	private String username;
	//部门
	private String dept;
	//性别1：男0：女
	private Long sex;
	//身份证号
	private String idCard;
	//出生日期
	private String birth;
	//年龄
	private Integer age;
	//退休天数
	private Integer retireDays;

}
