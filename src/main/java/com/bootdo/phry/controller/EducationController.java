package com.bootdo.phry.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.FileDO;
import com.bootdo.common.enums.Status;
import com.bootdo.common.service.FileService;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.phry.service.UserInfoService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.phry.domain.EducationDO;
import com.bootdo.phry.dto.EducationDTO;
import com.bootdo.phry.service.EducationService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 学历表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
 
@Controller
@RequestMapping("/phry/education")
public class EducationController {
	@Autowired
	private EducationService educationService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;

	@GetMapping()
	@RequiresPermissions("phry:education:education")
	String Education(){
	    return "phry/education/education";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:education:education")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<EducationDTO> educationList = educationService.list(query);
		educationList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = educationService.count(query);
		PageUtils pageUtils = new PageUtils(educationList, total);
		return pageUtils;
	}

	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:education:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/education/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:education:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/education/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:education:add")
	public R save( EducationDTO education){
		
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(education.getGraduationTime());
		 int yearStr1 = calendar.get(Calendar.YEAR);
		 
			Calendar calendar2 = Calendar.getInstance();
			 calendar2.setTime(education.getEntranceTime());
			 int yearStr2 = calendar2.get(Calendar.YEAR);
			 
			 education.setEduYear((yearStr1-yearStr2)+"");
		
		education.setCreateTime(new Date());
		education.setUpdateTime(new Date());
		education.setStatus(Status.正常.getCode());
		return educationService.save(education);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:education:edit")
	public R update( EducationDTO education){
		
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(education.getGraduationTime());
		 int yearStr1 = calendar.get(Calendar.YEAR);
		 
			Calendar calendar2 = Calendar.getInstance();
			 calendar2.setTime(education.getEntranceTime());
			 int yearStr2 = calendar2.get(Calendar.YEAR);
			 
			 education.setEduYear((yearStr1-yearStr2)+"");
		
		if(education.getEducationId()==null){
			return R.error("请选择存在的修改项");
		}
		education.setUpdateTime(new Date());
		return educationService.update(education);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/get/{educationId}")
	public R get(@PathVariable("educationId") Long educationId){

		EducationDTO educationDTO = educationService.get(educationId);
		educationDTO.setFileDO(sysFileService.get(educationDTO.getGraduationFileId()));
		educationDTO.setFileDO1(sysFileService.get(educationDTO.getAwardFileId()));
		return R.ok().put("eductionDTO",educationDTO);
	}

	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/education/look";
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:education:remove")
	public R remove( Long educationId){

		EducationDTO education = new EducationDTO();
		education.setEducationId(educationId);
		education.setStatus(Status.禁用.getCode());
		return educationService.update(education);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:education:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] educationIds){
		for (Long educationId:educationIds) {
			EducationDTO education = new EducationDTO();
			education.setEducationId(educationId);
			education.setStatus(Status.禁用.getCode());
			educationService.update(education);
		}
		return R.ok();
	}

//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("phry:education:remove")
//	public R remove( Long educationId){
//		if(educationService.remove(educationId)>0){
//			return R.ok();
//		}
//		return R.error();
//	}
//
//	/**
//	 * 删除
//	 */
//	@PostMapping( "/batchRemove")
//	@ResponseBody
//	@RequiresPermissions("phry:education:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] educationIds){
//		educationService.batchRemove(educationIds);
//		return R.ok();
//	}

	@ResponseBody
	@RequestMapping("/setHeightEdu/{educationId}")
	public R setHeightEdu(@PathVariable("educationId") Long educationId){

		R r = educationService.setHeightEdu(educationId);
		return r;
	}

	@ResponseBody
	@RequestMapping("/getHeightEdu/{userId}")
	public R getHeightEdu(@PathVariable("userId") Long userId){

		Map map = new HashedMap();
		map.put("userId",userId);
		List<EducationDTO> list = educationService.list(map);
		EducationDTO educationDTO = new EducationDTO();
		for (EducationDTO e:list) {
			if(e.getHeightEdu()!=null && e.getHeightEdu()==1){
				educationDTO = e;
			}
		}
		return R.ok().put("educationDTO",educationDTO);
	}
}
