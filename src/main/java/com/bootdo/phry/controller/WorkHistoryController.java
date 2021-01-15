package com.bootdo.phry.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.bootdo.phry.domain.WorkHistoryDO;
import com.bootdo.phry.dto.WorkHistoryDTO;
import com.bootdo.phry.service.WorkHistoryService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 家庭成员表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
 
@Controller
@RequestMapping("/phry/workHistory")
public class WorkHistoryController {
	@Autowired
	private WorkHistoryService workHistoryService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;

	@GetMapping()
	@RequiresPermissions("phry:workHistory:workHistory")
	String WorkHistory(@RequestParam Map<String, Object> params,Model model){
		List<UserInfoDTO> userInfoDTOList = userInfoService.list(params);
		Long userId = 0l;
		if(params.get("userId")!=null){
			userId = Long.parseLong( String.valueOf(params.get("userId")));
		}
		model.addAttribute("userId",userId==null?0:userId);
		model.addAttribute("userInfoDTOList",userInfoDTOList);
	    return "phry/workHistory/workHistory";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:workHistory:workHistory")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WorkHistoryDTO> workHistoryList = workHistoryService.list(query);
		workHistoryList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = workHistoryService.count(query);
		PageUtils pageUtils = new PageUtils(workHistoryList, total);
		return pageUtils;
	}

	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:workHistory:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/workHistory/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:workHistory:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/workHistory/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:workHistory:add")
	public R save( WorkHistoryDTO workHistory) throws ParseException {
		workHistory.setCreateTime(new Date());
		workHistory.setUpdateTime(new Date());
		workHistory.setStatus(Status.正常.getCode());
		if(workHistory.getLeavingTime()!=null && (workHistory.getLeavingTime()).length()> 0){
			String levaveTime=workHistory.getLeavingTime()+"-01";
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date= myFormatter.parse(levaveTime);
			java.util.Date mydate= myFormatter.parse(myFormatter.format(workHistory.getCreateTime()));
			long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			int year= (int) Math.floor(day/365);
			workHistory.setWorkingYear(year);

		}
		else {
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=new Date();
			java.util.Date mydate= myFormatter.parse(myFormatter.format(workHistory.getCreateTime()));
			long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			int year= (int) Math.floor(day/365);
			workHistory.setWorkingYear(year);
		}
		return workHistoryService.save(workHistory);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:workHistory:edit")
	public R update( WorkHistoryDTO workHistory) throws ParseException {
		if(workHistory.getWorkId()==null){
			return R.error("请选择存在的修改项");
		}
		workHistory.setUpdateTime(new Date());
		if(workHistory.getLeavingTime()!=null && (workHistory.getLeavingTime()).length()> 0){
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			String levaveTime=workHistory.getLeavingTime()+"-01";
			java.util.Date date= myFormatter.parse(levaveTime);
			
			java.util.Date mydate= myFormatter.parse(myFormatter.format(workHistory.getCreateTime()));
			long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			int year= (int) Math.floor(day/365);
			workHistory.setWorkingYear(year);

		}
		else {
			SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date=new Date();
			java.util.Date mydate= myFormatter.parse(myFormatter.format(workHistory.getCreateTime()));
			long day=(date.getTime()-mydate.getTime())/(24*60*60*1000) + 1;
			int year= (int) Math.floor(day/365);
			workHistory.setWorkingYear(year);
		}
		return workHistoryService.update(workHistory);
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/get/{workId}")
	public R get(@PathVariable("workId") Long workId){
		WorkHistoryDTO workHistoryDTO = workHistoryService.get(workId);
		workHistoryDTO.setFileDO(sysFileService.get(workHistoryDTO.getDocumentFileId()));
		return R.ok().put("workHistoryDTO",workHistoryDTO);
	}

	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/workHistory/look";
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:workHistory:remove")
	public R remove( Long workId){
		WorkHistoryDTO workHistoryDTO = new WorkHistoryDTO();
		workHistoryDTO.setStatus(Status.禁用.getCode());
		workHistoryDTO.setWorkId(workId);
		return workHistoryService.update(workHistoryDTO);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:workHistory:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] workIds){
		for (Long workId:workIds) {
			WorkHistoryDTO workHistoryDTO = new WorkHistoryDTO();
			workHistoryDTO.setStatus(Status.禁用.getCode());
			workHistoryDTO.setWorkId(workId);
			workHistoryService.update(workHistoryDTO);
		}
		return R.ok();
	}

//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("phry:workHistory:remove")
//	public R remove( Long workId){
//		if(workHistoryService.remove(workId)>0){
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
//	@RequiresPermissions("phry:workHistory:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] workIds){
//		workHistoryService.batchRemove(workIds);
//		return R.ok();
//	}
}
