package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 请假表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 10:23:55
 */
@Data
public class LeaveDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//请假ID
	private Integer id;
	//合同表ID
	private Integer pactId;
	//姓名
	private String name;
	//部门
	private String department;
	//职位
	private String post;
	//请假开始时间
	private String leaveTime;
	//请假到什么时候
	private String endTime;
	//请假天数
	private String leaveDate;
	//请假原因
	private String leaveReason;

}
