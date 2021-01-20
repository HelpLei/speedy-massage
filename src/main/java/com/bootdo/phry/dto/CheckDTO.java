package com.bootdo.phry.dto;

import com.bootdo.common.domain.FileDO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
@Data
public class CheckDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//考核主键
	private Long checkId;
	//user_id
	private Long userId;
	//考核时间
	private String checkTime;
	//考核详情以及备注
	private String checkWord;
	//考核文件或者图片
	private String checkFileId;
	private UserInfoDTO userInfoDTO;
	
	List<FileDO> fileDOList;
	
	//考核年度
	private String checkYear;
	//考核等级
	private String checkGlass;


}
