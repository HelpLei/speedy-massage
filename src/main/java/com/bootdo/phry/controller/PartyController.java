package com.bootdo.phry.controller;

import java.util.ArrayList;
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

import com.bootdo.phry.domain.PartyDO;
import com.bootdo.phry.dto.PartyDTO;
import com.bootdo.phry.service.PartyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 党籍表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
 
@Controller
@RequestMapping("/phry/party")
public class PartyController {
	@Autowired
	private PartyService partyService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;

	@GetMapping()
	@RequiresPermissions("phry:party:party")
	String Party(@RequestParam Map<String, Object> params,Model model){
		List<UserInfoDTO> userInfoDTOList = userInfoService.list(params);
		Long userId = 0l;
		if(params.get("userId")!=null){
			userId = Long.parseLong( String.valueOf(params.get("userId")));
		}
		model.addAttribute("userId",userId==null?0:userId);
		model.addAttribute("userInfoDTOList",userInfoDTOList);
	    return "phry/party/party";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:party:party")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PartyDTO> partyList = partyService.list(query);
		partyList.forEach(e->{
			e.setUserInfoDTO(userInfoService.get(e.getUserId()));
		});
		int total = partyService.count(query);
		PageUtils pageUtils = new PageUtils(partyList, total);
		return pageUtils;
	}

	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:party:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/party/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:party:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/party/edit";
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
	@RequiresPermissions("phry:party:add")
	public R save( PartyDTO party){
		party.setCreateTime(new Date());
		party.setUpdateTime(new Date());
		party.setStatus(Status.正常.getCode());
		return partyService.save(party);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:party:edit")
	public R update( PartyDTO party){
		if(party.getPartyId()==null){
			return R.error("请选择存在的修改项");
		}
		party.setUpdateTime(new Date());
		return partyService.update(party);
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/get/{partyId}")
	public R get(@PathVariable("partyId") Long partyId){
		PartyDTO partyDTO = partyService.get(partyId);
		
	/*	partyDTO.setFileDO(sysFileService.get(partyDTO.getPartyFileId()));*/
		
		
		
		return R.ok().put("partyDTO",partyDTO);
	}

	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/party/look";
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:party:remove")
	public R remove( Long partyId){
		PartyDTO party = new PartyDTO();
		party.setPartyId(partyId);
		party.setStatus(Status.禁用.getCode());
		return partyService.update(party);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:party:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] partyIds){
		for (Long partyId:partyIds) {
			PartyDTO party = new PartyDTO();
			party.setPartyId(partyId);
			party.setStatus(Status.禁用.getCode());
			partyService.update(party);
		}
		return R.ok();
	}


//	/**
//	 * 删除
//	 */
//	@PostMapping( "/remove")
//	@ResponseBody
//	@RequiresPermissions("phry:party:remove")
//	public R remove( Long partyId){
//		if(partyService.remove(partyId)>0){
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
//	@RequiresPermissions("phry:party:batchRemove")
//	public R remove(@RequestParam("ids[]") Long[] partyIds){
//		partyService.batchRemove(partyIds);
//		return R.ok();
//	}
}
