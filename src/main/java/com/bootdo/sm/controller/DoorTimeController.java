package com.bootdo.sm.controller;

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

import com.bootdo.sm.domain.DoorTimeDO;
import com.bootdo.sm.dto.DoorTimeDTO;
import com.bootdo.sm.service.DoorTimeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
 
@Controller
@RequestMapping("/sm/doorTime")
public class DoorTimeController {
	@Autowired
	private DoorTimeService doorTimeService;
	
	@GetMapping()
	@RequiresPermissions("phry:doorTime:doorTime")
	String DoorTime(){
	    return "phry/doorTime/doorTime";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:doorTime:doorTime")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DoorTimeDTO> doorTimeList = doorTimeService.list(query);
		int total = doorTimeService.count(query);
		PageUtils pageUtils = new PageUtils(doorTimeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:doorTime:add")
	String add(){
	    return "phry/doorTime/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:doorTime:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		DoorTimeDTO doorTime = doorTimeService.get(id);
		model.addAttribute("doorTime", doorTime);
	    return "phry/doorTime/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:doorTime:add")
	public R save( DoorTimeDTO doorTime){
		return doorTimeService.save(doorTime);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:doorTime:edit")
	public R update( DoorTimeDTO doorTime){
		return doorTimeService.update(doorTime);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:doorTime:remove")
	public R remove( Integer id){
		if(doorTimeService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:doorTime:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		doorTimeService.batchRemove(ids);
		return R.ok();
	}
	
}
