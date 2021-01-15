package com.bootdo.phry.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.bootdo.phry.domain.CheckDO;
import com.bootdo.phry.dto.CheckDTO;
import com.bootdo.phry.dto.RewardsDTO;
import com.bootdo.phry.service.CheckService;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-09-18 09:49:57
 */
 
@Controller
@RequestMapping("/phry/check")
public class CheckController {
	@Autowired
	private CheckService checkService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;
	@GetMapping()
	@RequiresPermissions("phry:check:check")
	String Check(){
	    return "phry/check/check";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:check:check")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CheckDTO> checkList = checkService.list(query);
		checkList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = checkService.count(query);
		PageUtils pageUtils = new PageUtils(checkList, total);
		return pageUtils;
	}
	
	
	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:check:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
	    return "phry/check/add";
	}
	@GetMapping("/edit/{checkId}")
	@RequiresPermissions("phry:check:edit")
	String edit(@PathVariable("checkId") Long checkId,Model model){
		CheckDTO check = checkService.get(checkId);
		model.addAttribute("check", check);
	    return "phry/check/edit";
	}
	
	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/check/look";
	}
	//文件
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
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:check:add")
	public R save( CheckDTO check){
		return checkService.save(check);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:check:edit")
	public R update( CheckDTO check){
		return checkService.update(check);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:check:remove")
	public R remove( Long checkId){
		if(checkService.remove(checkId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:check:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] checkIds){
		checkService.batchRemove(checkIds);
		return R.ok();
	}
	
}
