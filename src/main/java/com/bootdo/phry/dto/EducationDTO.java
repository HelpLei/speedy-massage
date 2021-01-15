package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;

import com.bootdo.common.domain.FileDO;
import lombok.Data;



/**
 * 学历表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
@Data
public class EducationDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long educationId;
	//userId
	private Long userId;
	private UserInfoDTO userInfoDTO;
	//教育类别（全日制）
	private String eduCategory;
	private Long educationCodeId;
	//学历代码
	private String eduCode;
	//学历名称
	private String eduName;
	//学历年限（年）
	private String eduYear;
	//学位代码
	private String degreeCode;
	//学位名称
	private String degreeName;
	//学校名称
	private String schoolName;
	//专业类别
	private String subjectCategory;
	//专业名称
	private String subjectName;
	//入学时间
	private Date entranceTime;
	//毕业时间
	private Date graduationTime;
	//学位授予时间
	private Date awardTime;
	//毕业证书Id
	private Long graduationFileId;
	private FileDO fileDO;
	//学位证书Id
	private Long awardFileId;
	private FileDO fileDO1;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;

	private Integer heightEdu;
}
