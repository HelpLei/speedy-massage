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
 * @date 2019-09-18 09:49:57
 */
@Data
public class RewardsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long rewardsId;
	//userId
	private Long userId;
	//奖惩时间
	private String rewardsPunishmentTime;
	//奖惩说明
	private String rewardsWord;
	//奖惩资料，跟图片
	private String rewardsFileId;
	private UserInfoDTO userInfoDTO;
	
	List<FileDO> fileDOList;
	
	//奖惩名称
	private String honorName;
	//奖惩单位
	private String honorUnit;
	//文件号
	private String fileNumber;

}
