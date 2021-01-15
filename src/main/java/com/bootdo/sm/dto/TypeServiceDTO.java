package com.bootdo.sm.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import java.math.BigDecimal;


/**
 * 服务类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
@Data
public class TypeServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//类型ID
	private Integer id;
	//类型名称
	private String name;
	//类型时间
	private Integer typeTime;
	//类型详情
	private String nameDetail;
	//价格
	private BigDecimal price;
	//已预约总数量
	private Integer serviceCountf;
	//针对部位
	private String forParts;
	//调理疾病
	private String regulateContent;
	//服务内容
	private String serviceContent;
	//预约须知
	private String bookingInformation;
	//禁忌提示
	private String tabooPrompt;
	//现在状态0为启用，1为关闭
	private Integer type;
	//创建人的ID
	private Integer creatId;
	//创建人员
	private String creatName;
	//创建的时间
	private Date creatTime;
	//备注
	private String remark;

}
