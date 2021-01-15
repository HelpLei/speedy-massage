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

import com.bootdo.phry.domain.RewardsDO;
import com.bootdo.phry.dto.RewardsDTO;
import com.bootdo.phry.service.RewardsService;
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
@RequestMapping("/phry/rewards")
public class RewardsController {
	@Autowired
	private RewardsService rewardsService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;
	
	@GetMapping()
	@RequiresPermissions("phry:rewards:rewards")
	String Rewards(){
	    return "phry/rewards/rewards";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:rewards:rewards")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RewardsDTO> rewardsList = rewardsService.list(query);
		rewardsList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = rewardsService.count(query);
		PageUtils pageUtils = new PageUtils(rewardsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:rewards:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
	    return "phry/rewards/add";
	}
	
	
	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/rewards/look";
	}
	
	
	@GetMapping("/edit/{rewardsId}")
	@RequiresPermissions("phry:rewards:edit")
	String edit(@PathVariable("rewardsId") Long rewardsId,Model model){
		RewardsDTO rewards = rewardsService.get(rewardsId);
		model.addAttribute("rewards", rewards);
	    return "phry/rewards/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:rewards:add")
	public R save( RewardsDTO rewards){
		return rewardsService.save(rewards);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:rewards:edit")
	public R update( RewardsDTO rewards){
		return rewardsService.update(rewards);
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
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:rewards:remove")
	public R remove( Long rewardsId){
		if(rewardsService.remove(rewardsId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:rewards:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] rewardsIds){
		rewardsService.batchRemove(rewardsIds);
		return R.ok();
	}
	
}
