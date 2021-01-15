package com.bootdo.phry.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bootdo.common.domain.FileDO;
import com.bootdo.system.domain.DeptDO;
import lombok.Data;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-22 10:43:57
 */
@Data
public class UserInfoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//姓名
	private String username;
	//手机号
	private String mobile;
	//密码
	private String password;
	//身份证号
	private String idCard;
	//民族
	private String nation;
	//籍贯
	private String natives;
	//出生地
	private String birthPlace;
	//健康状况
	private String health;
	//性别1：男0：女
	private Long sex;
	//联系方式
	private String contact;
	//出身日期
	private Date birth;
	//现居住地
	private String liveAddress;
	//1：系统用户2：录入人员
	private Integer isOwner;
	//部门Id
	private Long deptId;
	private String deptName;
	private DeptDO deptDO;
	//状态 0:禁用，1:正常
	private Integer status;
	//创建用户id
	private Long userIdCreate;
	//头像
	private Long picId;
	private FileDO fileDO;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;

	//学历
	private String education;
	
	//人员类别
	private String personnelCategory;
	
	private Integer age;

	private String fileId;

	List<FileDO> fileDOList;
	
	private String partyFileId;
	//正常排序
	private Integer allsort;
	//带有部门的排序
	private Integer departmentSort;
	
	//档案号
	private String fileNumber;
	//奖惩资料
	private String rewardsFileId;
	//考核文件或者图片
	private String checkFileId;
	
	private String worktime;
	
	private String worktomehere;
	
	//职务名称
		private String officeName;
		//学校名称
		private String schoolName;
		//专业名称
		private String subjectName;
		//任职机构
		private String workInstitution;
		//工作时间
		private String workingTime;
		//入党时间
		private String partyEnterTime;
		
	
}
