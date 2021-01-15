package com.bootdo.phry.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.enums.Status;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.system.service.UserService;
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

import com.bootdo.phry.domain.FamilyDO;
import com.bootdo.phry.dto.FamilyDTO;
import com.bootdo.phry.service.FamilyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:48:45
 */
 
@Controller
@RequestMapping("/phry/family")
public class FamilyController {
	@Autowired
	private FamilyService familyService;
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping()
	@RequiresPermissions("phry:family:family")
	String Family(){
	    return "phry/family/family";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:family:family")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FamilyDTO> familyList = familyService.list(query);
		familyList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = familyService.count(query);

		PageUtils pageUtils = new PageUtils(familyList, total);
		return pageUtils;
	}

	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:family:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
//		List<UserInfoDTO> userInfoDTOList = userInfoService.list(map);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
//		model.addAttribute("userId",userId==null?0:userId);
//		model.addAttribute("userInfoDTOList",userInfoDTOList);
	    return "phry/family/add";
	}

	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/family/look";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:family:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
	    return "phry/family/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:family:add")
	public R save( FamilyDTO family){
		family.setCreateTime(new Date());
		family.setUpdateTime(new Date());
		family.setStatus(Status.正常.getCode());
		return familyService.save(family);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:family:edit")
	public R update(FamilyDTO family){
		if(family.getFamilyId()==null){
			return R.error("请选择存在的修改项");
		}
		family.setUpdateTime(new Date());
		return familyService.update(family);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/get/{familyId}")
	public R get(@PathVariable("familyId") Long familyId){
		return R.ok().put("familyDTO",familyService.get(familyId));
	}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:family:remove")
	public R remove( Long familyId){

		FamilyDTO family = new FamilyDTO();
		family.setFamilyId(familyId);
		family.setStatus(Status.禁用.getCode());
		return familyService.update(family);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:family:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] familyIds){
		for (Long familyId:familyIds) {
			FamilyDTO family = new FamilyDTO();
			family.setFamilyId(familyId);
			family.setStatus(Status.禁用.getCode());
			familyService.update(family);
		}
		return R.ok();
	}

//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("phry:family:remove")
//	public R remove( Long familyId){
//		if(familyService.remove(familyId)>0){
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
//	@RequiresPermissions("phry:family:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] familyIds){
//		familyService.batchRemove(familyIds);
//		return R.ok();
//	}
	
}
