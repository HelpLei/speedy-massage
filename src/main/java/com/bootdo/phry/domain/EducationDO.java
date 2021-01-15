package com.bootdo.phry.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 学历表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
public class EducationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long educationId;
	//userId
	private Long userId;
	//教育类别（全日制）
	private String eduCategory;
	private Long educationCodeId;
	//学历代码
	private String eduCode;
	//学历名称
	private String eduName;
	//学历年限（年）
	private String eduYear;
	//学位代码
	private String degreeCode;
	//学位名称
	private String degreeName;
	//学校名称
	private String schoolName;
	//专业类别
	private String subjectCategory;
	//专业名称
	private String subjectName;
	//入学时间
	private Date entranceTime;
	//毕业时间
	private Date graduationTime;
	//学位授予时间
	private Date awardTime;
	//毕业证书Id
	private Long graduationFileId;
	//学位证书Id
	private Long awardFileId;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//状态 0:禁用，1:正常
	private Integer status;
	private Integer heightEdu;
	/**
	 * 设置：主键Id
	 */
	public void setEducationId(Long educationId) {
		this.educationId = educationId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getEducationId() {
		return educationId;
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
	 * 设置：教育类别（全日制）
	 */
	public void setEduCategory(String eduCategory) {
		this.eduCategory = eduCategory;
	}
	/**
	 * 获取：教育类别（全日制）
	 */
	public String getEduCategory() {
		return eduCategory;
	}
	/**
	 * 设置：学历代码
	 */
	public void setEduCode(String eduCode) {
		this.eduCode = eduCode;
	}
	/**
	 * 获取：学历代码
	 */
	public String getEduCode() {
		return eduCode;
	}
	/**
	 * 设置：学历名称
	 */
	public void setEduName(String eduName) {
		this.eduName = eduName;
	}
	/**
	 * 获取：学历名称
	 */
	public String getEduName() {
		return eduName;
	}
	/**
	 * 设置：学历年限（年）
	 */
	public void setEduYear(String eduYear) {
		this.eduYear = eduYear;
	}
	/**
	 * 获取：学历年限（年）
	 */
	public String getEduYear() {
		return eduYear;
	}
	/**
	 * 设置：学位代码
	 */
	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	/**
	 * 获取：学位代码
	 */
	public String getDegreeCode() {
		return degreeCode;
	}
	/**
	 * 设置：学位名称
	 */
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	/**
	 * 获取：学位名称
	 */
	public String getDegreeName() {
		return degreeName;
	}
	/**
	 * 设置：学校名称
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * 获取：学校名称
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * 设置：专业类别
	 */
	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}
	/**
	 * 获取：专业类别
	 */
	public String getSubjectCategory() {
		return subjectCategory;
	}
	/**
	 * 设置：专业名称
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 获取：专业名称
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * 设置：入学时间
	 */
	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}
	/**
	 * 获取：入学时间
	 */
	public Date getEntranceTime() {
		return entranceTime;
	}
	/**
	 * 设置：毕业时间
	 */
	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}
	/**
	 * 获取：毕业时间
	 */
	public Date getGraduationTime() {
		return graduationTime;
	}
	/**
	 * 设置：学位授予时间
	 */
	public void setAwardTime(Date awardTime) {
		this.awardTime = awardTime;
	}
	/**
	 * 获取：学位授予时间
	 */
	public Date getAwardTime() {
		return awardTime;
	}
	/**
	 * 设置：毕业证书Id
	 */
	public void setGraduationFileId(Long graduationFileId) {
		this.graduationFileId = graduationFileId;
	}
	/**
	 * 获取：毕业证书Id
	 */
	public Long getGraduationFileId() {
		return graduationFileId;
	}
	/**
	 * 设置：学位证书Id
	 */
	public void setAwardFileId(Long awardFileId) {
		this.awardFileId = awardFileId;
	}
	/**
	 * 获取：学位证书Id
	 */
	public Long getAwardFileId() {
		return awardFileId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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

	public Long getEducationCodeId() {
		return educationCodeId;
	}

	public void setEducationCodeId(Long educationCodeId) {
		this.educationCodeId = educationCodeId;
	}

	public Integer getHeightEdu() {
		return heightEdu;
	}

	public void setHeightEdu(Integer heightEdu) {
		this.heightEdu = heightEdu;
	}
}
