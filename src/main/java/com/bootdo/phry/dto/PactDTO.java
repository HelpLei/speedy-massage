package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bootdo.common.domain.FileDO;

import lombok.Data;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 15:53:38
 */
@Data
public class PactDTO implements Serializable {
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
	//在职状态(0为试用期，1为在职,2为提前离职，3已续签合同，4正常离职)
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
	//合同到期剩余时间
	private Integer lefttime;
	
	List<FileDO> fileDOList;
	
	
}
