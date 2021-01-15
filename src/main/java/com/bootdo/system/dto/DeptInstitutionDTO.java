package com.bootdo.system.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 机构管理
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:20
 */
@Data
public class DeptInstitutionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long deptId;
	//上级机构ID，一级机构为0
	private Long parentId;
	//机构名称
	private String name;
	//排序
	private Integer orderNum;
	//是否删除 1：已删除  0：正常
	private Integer delFlag;

}
