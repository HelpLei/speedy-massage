package com.bootdo.phry.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.domain.Tree;
import com.bootdo.common.enums.Status;
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

import com.bootdo.phry.domain.EducationCodeDO;
import com.bootdo.phry.dto.EducationCodeDTO;
import com.bootdo.phry.service.EducationCodeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 学历代码表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 09:28:39
 */
 
@Controller
@RequestMapping("/phry/educationCode")
public class EducationCodeController {
	@Autowired
	private EducationCodeService educationCodeService;
	
	@GetMapping()
	@RequiresPermissions("phry:educationCode:educationCode")
	String EducationCode(){
	    return "phry/educationCode/educationCode";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:educationCode:educationCode")
	public List<EducationCodeDTO> list(){
		//查询列表数据
		Map<String, Object> query = new HashMap<>(16);
		List<EducationCodeDTO> educationCodeList = educationCodeService.list(query);
		return educationCodeList;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("phry:educationCode:add")
	String add(@PathVariable("pId") Long pId, Model model) {
		model.addAttribute("pId", pId);
		
		if (pId==0) {
			model.addAttribute("pName", "总代码");
		} else {
			model.addAttribute("pName", educationCodeService.get(pId).getEducationCodeName());
		}
		return "phry/educationCode/add";
	}

	@GetMapping("/edit/{educationCodeId}")
	@RequiresPermissions("phry:educationCode:edit")
	String edit(@PathVariable("educationCodeId") Long educationCodeId, Model model) {
		EducationCodeDTO educationCode = educationCodeService.get(educationCodeId);
		model.addAttribute("educationCode", educationCode);
		if(educationCode.getParentId()==0) {
			model.addAttribute("educationCodeName", "无");
		}else {
			EducationCodeDTO parDept = educationCodeService.get(educationCode.getParentId());
			model.addAttribute("educationCodeName", parDept.getEducationCodeName());
		}
		return "phry/educationCode/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:educationCode:add")
	public R save( EducationCodeDTO educationCode){
	
		
		educationCode.setCreateTime(new Date());
		educationCode.setUpdateTime(new Date());
		educationCode.setStatus(Status.正常.getCode());
		return educationCodeService.save(educationCode);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:educationCode:edit")
	public R update( EducationCodeDTO educationCode){
		educationCode.setUpdateTime(new Date());
		return educationCodeService.update(educationCode);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:educationCode:remove")
	public R remove( Long educationCodeId){
		if(educationCodeService.remove(educationCodeId)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:educationCode:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] educationCodeIds){
		educationCodeService.batchRemove(educationCodeIds);
		return R.ok();
	}

	@GetMapping("/treeView")
	String treeView() {
		return "phry/educationCode/codeTree";
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<EducationCodeDTO> tree() {
		Tree<EducationCodeDTO> tree = new Tree<EducationCodeDTO>();
		tree = educationCodeService.getTree();
		return tree;
	}

	@ResponseBody
	@RequestMapping("/get/{educationCodeId}")
	public R get(@PathVariable("educationCodeId") Long educationCodeId){
		EducationCodeDTO educationCodeDTO = educationCodeService.get(educationCodeId);
		return R.ok().put("educationCodeDTO",educationCodeDTO);
	}

}
