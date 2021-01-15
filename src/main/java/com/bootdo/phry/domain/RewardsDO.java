package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
public class RewardsDO implements Serializable {
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

	//奖惩名称
	private String honorName;
	//奖惩单位
	private String honorUnit;
	//文件号
	private String fileNumber;
	
	
	
	public String getHonorName() {
		return honorName;
	}
	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}
	public String getHonorUnit() {
		return honorUnit;
	}
	public void setHonorUnit(String honorUnit) {
		this.honorUnit = honorUnit;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	/**
	 * 设置：主键Id
	 */
	public void setRewardsId(Long rewardsId) {
		this.rewardsId = rewardsId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getRewardsId() {
		return rewardsId;
	}
	/**
	 * 设置：userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：奖惩时间
	 */
	public void setRewardsPunishmentTime(String rewardsPunishmentTime) {
		this.rewardsPunishmentTime = rewardsPunishmentTime;
	}
	/**
	 * 获取：奖惩时间
	 */
	public String getRewardsPunishmentTime() {
		return rewardsPunishmentTime;
	}
	/**
	 * 设置：奖惩说明
	 */
	public void setRewardsWord(String rewardsWord) {
		this.rewardsWord = rewardsWord;
	}
	/**
	 * 获取：奖惩说明
	 */
	public String getRewardsWord() {
		return rewardsWord;
	}
	/**
	 * 设置：奖惩资料，跟图片
	 */
	public void setRewardsFileId(String rewardsFileId) {
		this.rewardsFileId = rewardsFileId;
	}
	/**
	 * 获取：奖惩资料，跟图片
	 */
	public String getRewardsFileId() {
		return rewardsFileId;
	}
}
