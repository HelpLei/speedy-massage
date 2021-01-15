package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bootdo.common.domain.FileDO;
import lombok.Data;



/**
 * 党籍表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
@Data
public class OnlyPartyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long partyId;
	//userId
	private Long userId;
	private UserInfoDTO userInfoDTO;
	//入党时间
	private Date partyEnterTime;
	//任职文号（图片）
	private String partyFileId;
	
	private FileDO fileDO;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;
	//姓名
	private String name;
	//身份证
	private String card;
	//照片
	private Long phoneId;
	
	// 部门
    private Long deptId;
    private String deptName;
    
    private String shouji;
    
	List<FileDO> fileDOList;

}
