package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-22 10:43:57
 */
public class UserInfoDO implements Serializable {
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
	//状态 0:禁用，1:正常
	private Integer status;
	//创建用户id
	private Long userIdCreate;
	//头像
	private Long picId;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModified;

	//学历
	private String education;
		
	//正常排序
	private Integer allsort;
	
	//带有部门的排序
	private Integer departmentSort;
	
	//档案号
	private String fileNumber;
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
	private Date partyEnterTime;
	
	
	public Date getPartyEnterTime() {
		return partyEnterTime;
	}

	public void setPartyEnterTime(Date partyEnterTime) {
		this.partyEnterTime = partyEnterTime;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getWorkInstitution() {
		return workInstitution;
	}

	public void setWorkInstitution(String workInstitution) {
		this.workInstitution = workInstitution;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getWorktomehere() {
		return worktomehere;
	}

	public void setWorktomehere(String worktomehere) {
		this.worktomehere = worktomehere;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public Integer getAllsort() {
		return allsort;
	}

	public void setAllsort(Integer allsort) {
		this.allsort = allsort;
	}

	public Integer getDepartmentSort() {
		return departmentSort;
	}

	public void setDepartmentSort(Integer departmentSort) {
		this.departmentSort = departmentSort;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPersonnelCategory() {
		return personnelCategory;
	}

	public void setPersonnelCategory(String personnelCategory) {
		this.personnelCategory = personnelCategory;
	}

	//人员类别
	private String personnelCategory;
	
	private Integer age;

	private String fileId;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：姓名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：籍贯
	 */
	public void setNatives(String natives) {
		this.natives = natives;
	}
	/**
	 * 获取：籍贯
	 */
	public String getNatives() {
		return natives;
	}
	/**
	 * 设置：出生地
	 */
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	/**
	 * 获取：出生地
	 */
	public String getBirthPlace() {
		return birthPlace;
	}
	/**
	 * 设置：健康状况
	 */
	public void setHealth(String health) {
		this.health = health;
	}
	/**
	 * 获取：健康状况
	 */
	public String getHealth() {
		return health;
	}
	/**
	 * 设置：性别1：男0：女
	 */
	public void setSex(Long sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别1：男0：女
	 */
	public Long getSex() {
		return sex;
	}
	/**
	 * 设置：联系方式
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：出身日期
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取：出身日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置：现居住地
	 */
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	/**
	 * 获取：现居住地
	 */
	public String getLiveAddress() {
		return liveAddress;
	}
	/**
	 * 设置：1：系统用户2：录入人员
	 */
	public void setIsOwner(Integer isOwner) {
		this.isOwner = isOwner;
	}
	/**
	 * 获取：1：系统用户2：录入人员
	 */
	public Integer getIsOwner() {
		return isOwner;
	}
	/**
	 * 设置：部门Id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：部门Id
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：头像
	 */
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	/**
	 * 获取：头像
	 */
	public Long getPicId() {
		return picId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
