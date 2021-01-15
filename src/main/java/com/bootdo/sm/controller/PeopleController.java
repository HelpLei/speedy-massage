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

import com.bootdo.sm.domain.PeopleDO;
import com.bootdo.sm.dto.PeopleDTO;
import com.bootdo.sm.service.PeopleService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 被服务人员姓名
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
 
@Controller
@RequestMapping("/sm/people")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping()
	@RequiresPermissions("phry:people:people")
	String People(){
	    return "phry/people/people";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:people:people")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PeopleDTO> peopleList = peopleService.list(query);
		int total = peopleService.count(query);
		PageUtils pageUtils = new PageUtils(peopleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:people:add")
	String add(){
	    return "phry/people/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:people:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PeopleDTO people = peopleService.get(id);
		model.addAttribute("people", people);
	    return "phry/people/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:people:add")
	public R save( PeopleDTO people){
		return peopleService.save(people);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:people:edit")
	public R update( PeopleDTO people){
		return peopleService.update(people);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:people:remove")
	public R remove( Integer id){
		if(peopleService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:people:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		peopleService.batchRemove(ids);
		return R.ok();
	}
	
}
