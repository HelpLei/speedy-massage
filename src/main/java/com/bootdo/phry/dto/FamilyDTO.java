package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
@Data
public class FamilyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long familyId;
	//userId
	private Long userId;
	private UserInfoDTO userInfoDTO;
	//称谓
	private String familyAppellation;
	//姓名
	private String familyName;
	//出生日期
	private String birthTime;
	//政治面貌
	private String politicsFace;
	//工作单位以及职务
	private String workUnits;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;

}
