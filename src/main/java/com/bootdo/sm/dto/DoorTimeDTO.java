package com.bootdo.sm.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Data
public class DoorTimeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//时间段ID
	private Integer id;
	//预约人员ID
	private Integer appointmentPersonId;
	//预约人员
	private String appointmentPerson;
	//预约时间
	private Date appointmentTime;
	//预约类型
	private Integer appointmentService;

}
