package com.bootdo.sm.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 被服务人员姓名
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Data
public class PeopleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//人员id
	private Integer id;
	//人员姓名
	private String name;
	//昵称
	private String nickname;
	//头像
	private Integer photo;
	//身份证
	private String card;
	//手机号
	private String phone;
	//生日
	private String birthday;
	//个人地址
	private String address;
	//消费次数
	private Integer consumeCount;
	//消费金额
	private BigDecimal consumePrice;
	//消费积分
	private Integer consumeIntegral;

}
