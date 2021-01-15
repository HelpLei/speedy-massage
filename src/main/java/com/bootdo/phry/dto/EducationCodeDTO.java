package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 学历代码表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 09:28:39
 */
@Data
public class EducationCodeDTO implements Serializable {
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

}
