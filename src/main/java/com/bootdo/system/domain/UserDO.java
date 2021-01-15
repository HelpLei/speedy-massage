package com.bootdo.system.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserDO implements Serializable {
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
    //性别
    private Long sex;
    //联系方式
    private String contact;
    //出身日期
    private Date birth;
    //现居住地
    private String liveAddress;
    //是否是本机构人员1：是0：不是
    private Integer isOwner;
    //部门Id
    private Long deptId;
    private String deptName;
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
    //角色
    private List<Long> roleIds;

    private Integer missNumber;

    private Date missTime;

    private Date allowTime;

    private Integer age;
    
	
	private String worktime;
	
	private String worktomehere;
}
