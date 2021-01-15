package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-04 16:47:00
 */
@Data
public class PartyFeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//人员id
	private Long userId;
	//人员姓名
	private String username;
	//性别1：男0：女
	private Long sex;
	//身份证号
	private String idCard;
	//党费金额
	private String money;
	//缴纳党费时间
	private Date payTime;

}
