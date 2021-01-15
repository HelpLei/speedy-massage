package com.bootdo.phry.dto;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * @oauth Yeohwah
 * @createDate 2019/12/16
 * @info
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyLocalExcelDTO implements Serializable {

    private static final long serialVersionUID = 6595166169161575965L;

    @Excel(name = "姓名")
    private String name;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "出生年月")
    private String birth;
    @Excel(name = "文化程度")
    private String education;
    @Excel(name = "入党时间")
    private String partyEnterTime;
    @Excel(name = "工作时间")
    private String worktime;
    @Excel(name = "进潘黄时间")
    private String worktomehere;
    @Excel(name = "编制性质")
    private String personnelCategory;
    @Excel(name = "现任职务")
    private String officeName;
    @Excel(name = "毕业院校/系以及专业")
    private String schoolName;
    @Excel(name = "工作简历")
    private String workInstitution;
}