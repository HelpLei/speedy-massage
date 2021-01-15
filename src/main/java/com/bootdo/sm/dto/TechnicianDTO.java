package com.bootdo.sm.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import java.math.BigDecimal;


/**
 * 技师人员
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Data
public class TechnicianDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//技师ID
	private Integer id;
	//技师会的技能
	private String typeId;
	//姓名
	private String name;
	//头像上传
	private Integer namePicture;
	//身份证
	private String card;
	//年龄
	private Integer age;
	//手机号
	private String phone;
	//地址
	private String address;
	//人员详情
	private String personDetail;
	//个人类型
	private Integer genre;
	//经济联系人姓名
	private String urgencyName;
	//紧急人关系
	private String urgencyRelation;
	//紧急联系人电话
	private String urgencyPhone;
	//加入时间
	private Date joinDate;
	//离职时间
	private Date outDate;
	//订单数
	private Integer numberOrders;
	//订单实际所获得的价格
	private BigDecimal numberSurePrice;
	//订单价格
	private BigDecimal numberPrice;
	//评价平均分数
	private BigDecimal evaluationScore;
	//证书名称
	private String credentialsName;
	//证书上传id
	private String credentialsFile;
	//证书名称
	private String credentialsNameTwo;
	//证书上传id
	private String credentialsFileTwo;
	//证书名称
	private String credentialsNameThree;
	//证书上传id
	private String credentialsFileThree;
	//证书名称
	private String credentialsNameFour;
	//证书上传id
	private String credentialsFileFour;
	//创建人员id
	private Integer creatId;
	//创建人员姓名
	private String creatName;
	//创建时间
	private Date creatTime;
	//0为正常，1为删除
	private Integer type;
	//备注
	private String remark;

}
