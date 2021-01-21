package com.bootdo.sm.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.sm.dto.GenreDTO;
import com.bootdo.sm.dto.TechnicianDTO;
import com.bootdo.sm.service.GenreService;
import com.bootdo.sm.service.TechnicianService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 技师人员
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
 
@Controller
@RequestMapping("/sm/technician")
public class TechnicianController {
	@Autowired
	private TechnicianService technicianService;
	@Autowired
	private GenreService genreService;
	@GetMapping()
	@RequiresPermissions("phry:technician:technician")
	String Technician(Model model){


	    return "sm/technician/technician";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:technician:technician")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TechnicianDTO> technicianList = technicianService.list(query);
		int total = technicianService.count(query);
		PageUtils pageUtils = new PageUtils(technicianList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:technician:add")
	String add(Model model){
		HashMap<String,Object> type=new HashMap<>();
		type.put("type","0");
		List<GenreDTO> genreList = genreService.list(type);
		model.addAttribute("labels", genreList);
	    return "sm/technician/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:technician:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TechnicianDTO technician = technicianService.get(id);
		model.addAttribute("technician", technician);
	    return "sm/technician/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:technician:add")
	public R save( TechnicianDTO technician){
		Date date=new Date();
		technician.setJoinDate(date);
		technician.setOutDate(date);
		technician.setCreatTime(date);
		return technicianService.save(technician);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:technician:edit")
	public R update( TechnicianDTO technician){
		Date date=new Date();
		technician.setCreatTime(date);

		return technicianService.update(technician);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:technician:remove")
	public R remove( Integer id){
		if(technicianService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:technician:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		technicianService.batchRemove(ids);
		return R.ok();
	}
	
}
