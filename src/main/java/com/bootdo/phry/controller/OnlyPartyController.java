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
import com.bootdo.system.domain.DeptDO;

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

import com.bootdo.phry.domain.DeptDangDO;
import com.bootdo.phry.domain.OnlyPartyDO;
import com.bootdo.phry.dto.OnlyPartyDTO;
import com.bootdo.phry.service.DeptDangService;
import com.bootdo.phry.service.OnlyPartyService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;

/**
 * 党籍表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-29 09:44:20
 */
 
@Controller
@RequestMapping("/phry/onlyParty")
public class OnlyPartyController {
	@Autowired
	private OnlyPartyService onlypartyService;
	
	@Autowired
	private DeptDangService deptDangService;
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
	    return "phry/onlyParty/onlyParty";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:party:party")
	public PageUtils list(@RequestParam Map<String, Object> params,String name ,String deptId){
		//查询列表数据
        Query query = new Query(params);
        query.put("card", name);
        query.put("deptId", deptId);
        List<OnlyPartyDTO> partyList=null;
        int total=0;
        if (ShiroUtils.getUser().getUsername().equals("潘黄党员")) {
        	if (name==null||name.equals("")) {
        		 name="123456789";
			}
        	
        	query.put("card", name);
	        query.put("deptId", "");
        	
         partyList = onlypartyService.list(query);
    		 total = onlypartyService.count(query);
		}else {
			query.put("card", name);
	        query.put("deptId", deptId);
		 partyList = onlypartyService.list(query);
		 total = onlypartyService.count(query);
		}
		PageUtils pageUtils = new PageUtils(partyList, total);
		return pageUtils;
	}

	/*@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:party:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		return "phry/onlyparty/add";
	}*/
	
	@GetMapping("/add")
	@RequiresPermissions("phry:party:add")
	String add(){
	    return "phry/onlyParty/add";
	}
	
	
	@GetMapping("/edit/{partyId}")
	@RequiresPermissions("phry:party:edit")
	String edit(@PathVariable("partyId") Long partyId,Model model){
		
		OnlyPartyDTO onlyParty = onlypartyService.get(partyId);
		
		DeptDangDO deptDO = deptDangService.get(onlyParty.getDeptId());
		if(deptDO!=null){
			onlyParty.setDeptName(deptDO.getName());
		}

		FileDO fileDO = sysFileService.get(onlyParty.getPhoneId());
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
		}
		model.addAttribute("fileDO",fileDO);
		
		String[] fileIds = onlyParty.getPartyFileId().split(",");
		List<FileDO> fileDOS = new ArrayList<>();
		for (String fileId:fileIds) {
			if(!"".equals(fileId)) {
				fileDOS.add(sysFileService.get(Long.parseLong(fileId)));
			}
		}
		onlyParty.setFileDOList(fileDOS);
		
		model.addAttribute("onlyParty", onlyParty);
	    return "phry/onlyParty/edit";
	}
	
	
	/*@GetMapping("/edit/{userId}")
	@RequiresPermissions("phry:party:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
		
		return "phry/onlyParty/edit";
	}
	*/
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
		
		for (int i = 0; i < fileIds.length; i++) {
			
		}
		
		String url="";
		if (fileDOImgList!=null||fileDOImgList.size()>0) {
//			int num=fileDOImgList.size();
			for ( int num=fileDOImgList.size()-1 ; num >= 0; num--) {
				if (url.equals("")||url==null) {
					url=fileDOImgList.get(num).getUrl();
				}else {
				url=fileDOImgList.get(num).getUrl()+","+url;
			}	
			}
		} 
		model.addAttribute("url",url);
		model.addAttribute("fileDODocList",fileDODocList);
		return "phry/onlyParty/showFiles";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:party:add")
	public R save( OnlyPartyDTO party){
		
		
		
		party.setCreateTime(new Date());
		party.setUpdateTime(new Date());
		party.setStatus(Status.正常.getCode());
		return onlypartyService.save(party);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:party:edit")
	public R update( OnlyPartyDTO party){
		if(party.getPartyId()==null){
			return R.error("请选择存在的修改项");
		}
		party.setUpdateTime(new Date());
		return onlypartyService.update(party);
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/get/{partyId}")
	public R get(@PathVariable("partyId") Long partyId){
		OnlyPartyDTO partyDTO = onlypartyService.get(partyId);
		
	/*	partyDTO.setFileDO(sysFileService.get(partyDTO.getPartyFileId()));*/
		
		
		
		return R.ok().put("partyDTO",partyDTO);
	}

	@GetMapping("/look/{userId}")
	String look(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);

		model.addAttribute("userInfoDTO",userInfoService.get(userId));

		return "phry/onlyParty/look";
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:party:remove")
	public R remove( Long partyId){
		OnlyPartyDTO party = new OnlyPartyDTO();
		party.setPartyId(partyId);
		party.setStatus(Status.禁用.getCode());
		return onlypartyService.update(party);
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:party:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] partyIds){
		for (Long partyId:partyIds) {
			OnlyPartyDTO party = new OnlyPartyDTO();
			party.setPartyId(partyId);
			party.setStatus(Status.禁用.getCode());
			onlypartyService.update(party);
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
