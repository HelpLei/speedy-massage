package com.bootdo.phry.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.bootdo.phry.domain.PersonFileDO;
import com.bootdo.phry.dto.PersonFileDTO;
import com.bootdo.phry.service.PersonFileService;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.ShiroUtils;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2020-04-14 11:36:29
 */
 
@Controller
@RequestMapping("/phry/personFile")
public class PersonFileController {
	@Autowired
	private PersonFileService personFileService;
	
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private FileService sysFileService;
	
	@GetMapping()
	@RequiresPermissions("phry:personFile:personFile")
	String PersonFile(){
	    return "phry/personFile/personFile";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:personFile:personFile")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PersonFileDTO> personFileList = personFileService.list(query);
		int total = personFileService.count(query);
		PageUtils pageUtils = new PageUtils(personFileList, total);
		return pageUtils;
	}
	
	
	
	@GetMapping("/add/{userId}")
	@RequiresPermissions("phry:personFile:add")
	String add(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
	    return "phry/personFile/add";
	}
	
	@GetMapping("/addOther/{userId}")
	@RequiresPermissions("phry:personFile:add")
	String addOther(@PathVariable("userId") Long userId,Model model){
		Map map = new HashedMap();
		map.put("userId",userId);
		model.addAttribute("userInfoDTO",userInfoService.get(userId));
	    return "phry/personFile/addOther";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:personFile:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PersonFileDTO personFile = personFileService.get(id);
		model.addAttribute("personFile", personFile);
	    return "phry/personFile/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:personFile:add")
	public R save( PersonFileDTO personFile){

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		
		personFile.setAddTime(df.format(new Date()));
		personFile.setCreatId(ShiroUtils.getUserId()+"");
		personFile.setCreatName(ShiroUtils.getUser().getUsername());
		personFile.setStyle(1);
		return personFileService.save(personFile);
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveOther")
	@RequiresPermissions("phry:personFile:add")
	public R saveOther( PersonFileDTO personFile){
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		
		personFile.setAddTime(df.format(new Date()));
		personFile.setCreatId(ShiroUtils.getUserId()+"");
		personFile.setCreatName(ShiroUtils.getUser().getUsername());
		
		
		personFile.setStyle(0);
		return personFileService.save(personFile);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:personFile:edit")
	public R update( PersonFileDTO personFile){
		return personFileService.update(personFile);
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
	@RequiresPermissions("phry:personFile:remove")
	public R remove( Integer id){
		if(personFileService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:personFile:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		personFileService.batchRemove(ids);
		return R.ok();
	}
	
}
