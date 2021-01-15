package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;

import com.bootdo.common.domain.FileDO;
import lombok.Data;



/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
@Data
public class WorkHistoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long workId;
	//userId
	private Long userId;
	private UserInfoDTO userInfoDTO;
	//工作经历是否有两年以上1：是 0：否
	private Integer workTime;
	//全称
	private String workAllName;
	//简称
	private String workSimpleName;
	//任职机构
	private String workInstitution;
	//任职名称
	private String workName;
	//职务名称
	private String officeName;
	//成员类别
	private String workCategory;
	//选拔任用方式
	private String selectMethods;
	//任职文号（图片）
	private Long documentFileId;
	private FileDO fileDO;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;

	private String workingTime;

	private String leavingTime;

	private int workingYear;

}
