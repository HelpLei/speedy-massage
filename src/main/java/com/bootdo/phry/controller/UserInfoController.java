package com.bootdo.phry.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.bootdo.phry.dto.SubsidyLocalExcelDTO;
import com.bootdo.common.annotation.Log;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.enums.UserType;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.common.utils.EasyPoiUtil;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.common.enums.Status;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.service.DeptService;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.phry.service.UserInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.phry.domain.CheckDO;
import com.bootdo.phry.domain.PartyDO;
import com.bootdo.phry.domain.RewardsDO;
import com.bootdo.phry.domain.UserInfoDO;
import com.bootdo.phry.dto.CheckDTO;
import com.bootdo.phry.dto.LeaveDTO;
import com.bootdo.phry.dto.PartyDTO;
import com.bootdo.phry.service.CheckService;
import com.bootdo.phry.service.LeaveService;
import com.bootdo.phry.service.PartyService;
import com.bootdo.phry.service.RewardsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-22 10:43:57
 */
 
@Controller
@RequestMapping("/phry/user")
public class UserInfoController {
	@Autowired
	private UserInfoService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private FileService sysFileService;
	@Autowired
	private CheckService checkService;
	@Autowired
	private RewardsService rewardsService;
	@Autowired
	private PartyService partyService;
	
	@GetMapping()
	@RequiresPermissions("phry:user:user")
	String User(){
	    return "phry/userinfo/user";
	}
	
	@ResponseBody
	@GetMapping("/CRlist")
	public PageUtils CRlist(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CheckDTO> checkList = checkService.CRlist(query);
		
		int total = checkService.CRcount(query);
		PageUtils pageUtils = new PageUtils(checkList, total);
		return pageUtils;
	}
	
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){

        Query query = new Query(params);
		List<UserInfoDTO> userList = userService.list(query);
		userList.forEach(e->{
			e.setDeptDO(deptService.get(e.getDeptId()));
		});
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listweixin")
	public PageUtils listweixin(@RequestParam Map<String, Object> params){

        Query query = new Query(params);
		List<UserInfoDTO> userList = userService.listweixin(query);
		userList.forEach(e->{
			e.setDeptDO(deptService.get(e.getDeptId()));
		});
		int total = userService.countweixin(query);
 		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listPart")
	@RequiresPermissions("phry:user:user")
	public PageUtils listPart(@RequestParam Map<String, Object> params)throws Exception{

        Query query = new Query(params);
		List<UserInfoDTO> userList = userService.list(query);
		userList.forEach(e->{
			e.setDeptDO(deptService.get(e.getDeptId()));
		});
		for (UserInfoDTO userInfoDTO : userList) {
			userInfoDTO.getUserId();
			PartyDO  partyDO=partyService.searchFile(userInfoDTO.getUserId());
			if (partyDO != null) {
				userInfoDTO.setPartyFileId(partyDO.getPartyFileId());	
			}
			
			
		}
		
		
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	
	@ResponseBody
	@GetMapping("/listRewards")
	@RequiresPermissions("phry:user:user")
	public PageUtils listRewards(@RequestParam Map<String, Object> params)throws Exception{

        Query query = new Query(params);
		List<UserInfoDTO> userList = userService.list(query);
		userList.forEach(e->{
			e.setDeptDO(deptService.get(e.getDeptId()));
		});
		for (UserInfoDTO userInfoDTO : userList) {
			userInfoDTO.getUserId();
			/*PartyDO  partyDO=partyService.searchFile(userInfoDTO.getUserId());
			if (partyDO != null) {
				userInfoDTO.setPartyFileId(partyDO.getPartyFileId());	
			}*/
			RewardsDO rewardsDO=rewardsService.searchFile(userInfoDTO.getUserId());
			if (rewardsDO != null) {
				userInfoDTO.setRewardsFileId(rewardsDO.getRewardsFileId());
			}
		}
		
		
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listCheck")
	@RequiresPermissions("phry:user:user")
	public PageUtils listCheck(@RequestParam Map<String, Object> params)throws Exception{

        Query query = new Query(params);
		List<UserInfoDTO> userList = userService.list(query);
		userList.forEach(e->{
			e.setDeptDO(deptService.get(e.getDeptId()));
		});
		for (UserInfoDTO userInfoDTO : userList) {
			userInfoDTO.getUserId();
			CheckDO checkDO=checkService.searchFile(userInfoDTO.getUserId());
			if (checkDO != null) {
				userInfoDTO.setCheckFileId(checkDO.getCheckFileId());
			}
		}
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:user:add")
	String add(){
	    return "phry/userinfo/add";
	}

/*	@GetMapping("/addOther/{userId}")
	@RequiresPermissions("phry:user:add")
	String add(@PathVariable("userId") Long userId,Model model){
		UserInfoDTO user = userService.get(userId);
		DeptDO deptDO = deptService.get(user.getDeptId());
		if(deptDO!=null){
			user.setDeptName(deptDO.getName());
		}

		FileDO fileDO = sysFileService.get(user.getPicId());
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
		}
		model.addAttribute("fileDO",fileDO);

		String[] fileIds = user.getFileId().split(",");
		List<FileDO> fileDOS = new ArrayList<>();
		for (String fileId:fileIds) {
			if(!"".equals(fileId)) {
				fileDOS.add(sysFileService.get(Long.parseLong(fileId)));
			}
		}
		user.setFileDOList(fileDOS);
		model.addAttribute("user", user);
	    return "phry/userinfo/editOther";
	}*/
	
	@GetMapping("/doUserMain/{userId}")
	String doUserMain(Model model,@PathVariable("userId") Long userId){
		model.addAttribute("userId",userId);
		return "phry/userinfo/userinfo/doUserMain";
	}

	@GetMapping("/showUserInfo/{userId}")
	String showUserInfo(Model model,@PathVariable("userId") Long userId){
		model.addAttribute("userInfoDTO",userService.get(userId));
		return "phry/userinfo/userinfo/showUserInfo";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:user:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		UserInfoDTO user = userService.get(userId);
		DeptDO deptDO = deptService.get(user.getDeptId());
		if(deptDO!=null){
			user.setDeptName(deptDO.getName());
		}

		FileDO fileDO = sysFileService.get(user.getPicId());
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
		}
		model.addAttribute("fileDO",fileDO);

		String[] fileIds = user.getFileId().split(",");
		List<FileDO> fileDOS = new ArrayList<>();
		for (String fileId:fileIds) {
			if(!"".equals(fileId)) {
				fileDOS.add(sysFileService.get(Long.parseLong(fileId)));
			}
		}
		user.setFileDOList(fileDOS);
		model.addAttribute("user", user);

	    return "phry/userinfo/edit";
	}
	
	@GetMapping("/changeXuhao/{userId}")
	@RequiresPermissions("phry:user:edit")
	String changeXuhao(@PathVariable("userId") Long userId,Model model){
		UserInfoDTO user = userService.get(userId);
		model.addAttribute("user", user);
	    return "phry/userinfo/changeXuhao";
	}
	
	
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:user:add")
	public R save(UserInfoDTO user) throws ParseException{

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String birthDateYear=user.getIdCard().substring(6, 10);
		String birthDateMoneth=user.getIdCard().substring(10, 12);
		String birthDateDate=user.getIdCard().substring(12, 14);
		String s=birthDateYear+"-"+birthDateMoneth+"-"+birthDateDate;
		Date dateTime =  myFormatter.parse(s);
		user.setBirth(dateTime);
		java.util.Date date=new Date();
		java.util.Date mydate= myFormatter.parse(myFormatter.format(user.getBirth()));
		long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
		int year= (int) Math.floor(day/365);
		user.setAge(year);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		user.setStatus(Status.正常.getCode());
	
		
		int allTotal = userService.allcount();
		if (user.getAllsort() == null) {
			int total = userService.partCount(user.getDeptId());
			user.setAllsort(allTotal+1);
			user.setDepartmentSort(total+1);
		}
		
		R r=userService.save(user);
		return r;
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:user:edit")
	public R update( UserInfoDTO user) throws ParseException{
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String birthDateYear=user.getIdCard().substring(6, 10);
		String birthDateMoneth=user.getIdCard().substring(10, 12);
		String birthDateDate=user.getIdCard().substring(12, 14);
		String s=birthDateYear+"-"+birthDateMoneth+"-"+birthDateDate;
		Date dateTime =  myFormatter.parse(s);
		user.setBirth(dateTime);
		
		java.util.Date date=new Date();
		java.util.Date mydate= myFormatter.parse(myFormatter.format(user.getBirth()));
		long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
		int year= (int) Math.floor(day/365);
		user.setAge(year);

		user.setGmtModified(new Date());
		R r=userService.update(user);
		return r;
	}
	
	/**
	 * 修改序号
	 */
	@ResponseBody
	@RequestMapping("/updateXuhao")
	@RequiresPermissions("phry:user:edit")
	public R updateXuhao( UserInfoDTO user) throws ParseException{
		int choose=user.getAllsort();
	/*	UserInfoDTO userThis=userService.get(user.getUserId());
		int forget=userThis.getAllsort();
		if (choose<forget) {
			for (int i = 0; choose <= forget-1; i++) {
				choose=choose+1;
				int change=forget-i-1;
				 userService.updateSort(change);
			}
			
		}
		if (choose>forget) {
			for (int i = 0; forget <= choose-1; i++) {
				choose=choose-1;
				int change=forget+i+1;
				 userService.updateSort2(change);
			}
			
		}*/
		Integer num=userService.getSortCount(user.getAllsort());
		if (num>0) {
			R.ok(user.getAllsort()+"序号已有，请尽快修改");
			userService.update(user);
			return R.error(2, user.getAllsort()+"序号已有，请尽快修改");
		}
		return userService.update(user);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:user:remove")
	public R remove( Long userId){
		UserInfoDTO user = new UserInfoDTO();
		user.setUserId(userId);
		user.setStatus(Status.禁用.getCode());
		return userService.update(user);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:user:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		userService.batchRemove(userIds);
		for (Long userId:userIds) {
			UserInfoDTO user = new UserInfoDTO();
			user.setUserId(userId);
			user.setStatus(Status.禁用.getCode());
			userService.update(user);
		}
		return R.ok();
	}
	//性别分析饼状图
	@GetMapping("/sexreport")
	@RequiresPermissions("phry:user:sexreport")
	String sexreport(){
	    return "phry/userinfo/sexreport";
	}

	@ResponseBody
	@PostMapping(value="/sexreportList")
	@RequiresPermissions("phry:user:sexreport")
	public R sexreportList(){
		//查询列表数据
	
		int man = userService.mancount();
		int woman=userService.womancount();
		
		return R.ok().put("man", man).put("woman", woman);
	}

	@GetMapping("/showFile/{fileId}")
	String showFile(@PathVariable("fileId") Long fileId,Model model){

		FileDO fileDO = sysFileService.get(fileId);
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
			fileDO.setOriginalFilename(".jpg");

		}
		model.addAttribute("fileDO",fileDO);
		return "phry/userinfo/userinfo/showFile";
	}

	@GetMapping("/showFiles/{fileIdList}")
	String showFiles(@PathVariable("fileIdList") String fileIdList,Model model){

		String[] fileIds = fileIdList.split(",");
		List<FileDO> fileDOImgList = new ArrayList<>();
		List<FileDO> fileDODocList = new ArrayList<>();

		for (String fileId:fileIds) {
			FileDO fileDO = sysFileService.get(Long.parseLong(fileId));
			if(fileDO.getType()==0) {
				fileDOImgList.add(fileDO);
			}else{
				fileDODocList.add(fileDO);
			}
		}
		model.addAttribute("fileDOImgList",fileDOImgList);
		model.addAttribute("fileDODocList",fileDODocList);
		return "phry/userinfo/userinfo/showFiles";
	}

	//用工本地化率报表
		@GetMapping("/local")
		@RequiresPermissions("phry:user:add")
		String local(Model model){
			String[] steps = new String[]{"姓名","性别","出生年月","文化程度","入党时间","工作时间","进潘黄时间","编制性质","现任职务","毕业院校/系以及专业","工作简历"};
			model.addAttribute("steps", steps);
			return "phry/userinfo/local";
		}
	
	
	 /**
 	 * 基础数据导出
 	 */
    @Log("基础数据导出")
    @GetMapping( "/exportLocal")
 	@RequiresPermissions("phry:user:add")
    public void exportLocal(String names,HttpServletResponse response) throws Exception {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    	String date=df.format(new Date());
 		 String fileName="基础数据报表"+date+".xls";
 		boolean  a=true;
 		boolean  b=true;
 		boolean  c=true;
 		boolean  d=true;
 		boolean  e=true;
 		boolean  f=true;
 		boolean  g=true;
 		boolean  h=true;
 		boolean  ii=true;
 		boolean  j=true;
 		boolean  k=true;
 		 String[] result = names.split(",");
 		   for (int i = 0; i < result.length; i++) {
 			  String userName=  (result[i]);
 			 if(userName.equals("姓名")) {
 	 		 a=false;
 	 		}
 	 		if(userName.equals("性别")) {
 	 		b=false;
 	 		}
 	 		if(userName.equals("出生年月")) {
 	 		c=false;
 	 		}
 	 		if(userName.equals("文化程度")) {
 	 		d=false;
 	 		}
 	 		if(userName.equals("入党时间")) {
 	 	 	 e=false;
 	 	 	}
 	 	 	if(userName.equals("工作时间")) {
 	 	 	f=false;
 	 	 	}
 	 	 	if(userName.equals("进潘黄时间")) {
 	 	 	g=false;
 	 	 	}
 	 	 	if(userName.equals("编制性质")) {
 	 	 	h=false;
 	 	 	}
 	 	 	if(userName.equals("现任职务")) {
 	 	 	ii=false;
 	 	 	}
 	 	 	 if(userName.equals("毕业院校/系以及专业")) {
 	 	 	 j=false;
 	 	 	 }
 	 	 	 if(userName.equals("工作简历")) {
 	 	 	 k=false;
 	 	 	 }
 	 	 	
 		   }
 		 
 	        List<SubsidyLocalExcelDTO> list=new ArrayList<>();
 	       
			//查询列表数据
 	       
 	       HashMap<String, Object> params = new HashMap<>();
 			/*List<InterviewListDO> interviewListList = interviewListService.listLocal(params);*/
 	      List<UserInfoDO> userList = userService.listLocal(params);
 			
 			for (int jj = 0; jj < userList.size(); jj++) {
 				 SubsidyLocalExcelDTO dto2 = new SubsidyLocalExcelDTO();
 				 String namegood=userList.get(jj).getUsername();
 				dto2.setName(namegood);
 				if (userList.get(jj).getSex()!=null||!userList.get(jj).getSex().equals("")) {
 					if (userList.get(jj).getSex()==1) {
 						String sexs="男";
 						dto2.setSex(sexs);
 					}else {
 						String sexs="女";
 						dto2.setSex(sexs);
 					}
				}else {
					dto2.setSex("男");
				}
 				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
 		    	String birth=df2.format(userList.get(jj).getBirth());
 				
 				dto2.setBirth(birth);
 				dto2.setEducation(userList.get(jj).getEducation());
 				//
 				String partyTime;
 				if (userList.get(jj).getPartyEnterTime()==null||userList.get(jj).getPartyEnterTime().equals("")) {
 					partyTime="未录入或还未入党";
				}else {
 				 partyTime=df2.format(userList.get(jj).getPartyEnterTime());
				}
 				dto2.setPartyEnterTime(partyTime);
 				dto2.setWorktime(userList.get(jj).getWorktime());
 				dto2.setWorktomehere(userList.get(jj).getWorktomehere());
 				String work;
 				if (userList.get(jj).getPersonnelCategory().equals("0")) {
 					work="行政";
				}else if(userList.get(jj).getPersonnelCategory().equals("1")) {
 					work="事业";
					
				}else if(userList.get(jj).getPersonnelCategory().equals("3")) {
 					work="编外人员(退役军人安置)";
					
				}else if(userList.get(jj).getPersonnelCategory().equals("4")) {
 					work="编外人员(军嫂安置)";
					
				}else if(userList.get(jj).getPersonnelCategory().equals("5")) {
 					work="编外人员(大学生村官)";
				}else {
					work="编外人员";
				}
 				
 				
 				dto2.setPersonnelCategory(work);
 				//
 				dto2.setOfficeName(userList.get(jj).getOfficeName());
 				//
 				if (userList.get(jj).getSchoolName()==null||userList.get(jj).getSchoolName().equals("")||userList.get(jj).getSubjectName()==null||userList.get(jj).getSubjectName().equals("")) {
 					dto2.setSchoolName("还未录入");
 				}else {
 					dto2.setSchoolName(userList.get(jj).getSchoolName()+"/"+userList.get(jj).getSubjectName());
 				}
 				
 				//工作简历
 				if (userList.get(jj).getWorkingTime()==null||userList.get(jj).getWorkingTime().equals("")||userList.get(jj).getWorkInstitution()==null||userList.get(jj).getWorkInstitution().equals("")||userList.get(jj).getOfficeName()==null||userList.get(jj).getOfficeName().equals("")) {
 					dto2.setWorkInstitution("无");
 				}else {
 					dto2.setWorkInstitution("于"+userList.get(jj).getWorkingTime()+"就职于"+userList.get(jj).getWorkInstitution()+"担任"+userList.get(jj).getOfficeName()+"的职位");
				}
 				
 				list.add(dto2);
			}
 			
 			
 			
 	        
 	        for(SubsidyLocalExcelDTO dto :list){
 	            EasyPoiUtil<SubsidyLocalExcelDTO> easyPoiUtil = new EasyPoiUtil<>(dto);
 	            easyPoiUtil.hideColumn("name", a);
 	            easyPoiUtil.hideColumn("sex", b);
 	            easyPoiUtil.hideColumn("birth", c);
 	          	easyPoiUtil.hideColumn("education", d);
 	           easyPoiUtil.hideColumn("partyEnterTime", e);
	            easyPoiUtil.hideColumn("worktime", f);
	            easyPoiUtil.hideColumn("worktomehere", g);
	          	easyPoiUtil.hideColumn("personnelCategory", h);
	            easyPoiUtil.hideColumn("officeName", ii);
 	            easyPoiUtil.hideColumn("schoolName", j);
 	            easyPoiUtil.hideColumn("workInstitution", k);
 	          	
 	        }
 	        ExportParams exportParams = new ExportParams();
 	        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SubsidyLocalExcelDTO.class, list);
 	        try {
 	            response.setCharacterEncoding("UTF-8");
 	            response.setHeader("content-Type", "application/vnd.ms-excel");
 	            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
 	            workbook.write(response.getOutputStream());
 	       } catch (IOException e1) {
 	            throw new RuntimeException(e1);
 	        }
 	    }

	
}
