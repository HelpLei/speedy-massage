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
 * @date 2020-04-14 11:36:29
 */
@Data
public class PersonFileDTO implements Serializable {
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
	
private UserInfoDTO userInfoDTO;
	
	List<FileDO> fileDOList;

}
