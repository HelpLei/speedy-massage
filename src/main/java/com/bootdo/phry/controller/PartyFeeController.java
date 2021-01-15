package com.bootdo.phry.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.phry.domain.PartyFeeDO;
import com.bootdo.phry.dto.PartyFeeDTO;
import com.bootdo.phry.service.PartyFeeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-04 16:47:00
 */
 
@Controller
@RequestMapping("/phry/partyFee")
public class PartyFeeController {
	@Autowired
	private PartyFeeService partyFeeService;
	
	@GetMapping()
	@RequiresPermissions("phry:partyFee:partyFee")
	String PartyFee(){
	    return "phry/partyFee/partyFee";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:partyFee:partyFee")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PartyFeeDTO> partyFeeList = partyFeeService.list(query);
		int total = partyFeeService.count(query);
		PageUtils pageUtils = new PageUtils(partyFeeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:partyFee:add")
	String add(){
	    return "phry/partyFee/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:partyFee:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PartyFeeDTO partyFee = partyFeeService.get(id);
		model.addAttribute("partyFee", partyFee);
	    return "phry/partyFee/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:partyFee:add")
	public R save( PartyFeeDTO partyFee){
		return partyFeeService.save(partyFee);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:partyFee:edit")
	public R update( PartyFeeDTO partyFee){
		return partyFeeService.update(partyFee);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:partyFee:remove")
	public R remove( Long id){
		if(partyFeeService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:partyFee:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		partyFeeService.batchRemove(ids);
		return R.ok();
	}
	
}
