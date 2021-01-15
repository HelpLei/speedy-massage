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

import com.bootdo.sm.domain.GenreDO;
import com.bootdo.sm.dto.GenreDTO;
import com.bootdo.sm.service.GenreService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 个人类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
 
@Controller
@RequestMapping("/sm/genre")
public class GenreController {
	@Autowired
	private GenreService genreService;
	
	@GetMapping()
	@RequiresPermissions("phry:genre:genre")
	String Genre(){
	    return "phry/genre/genre";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:genre:genre")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GenreDTO> genreList = genreService.list(query);
		int total = genreService.count(query);
		PageUtils pageUtils = new PageUtils(genreList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:genre:add")
	String add(){
	    return "phry/genre/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:genre:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GenreDTO genre = genreService.get(id);
		model.addAttribute("genre", genre);
	    return "phry/genre/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:genre:add")
	public R save( GenreDTO genre){
		return genreService.save(genre);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:genre:edit")
	public R update( GenreDTO genre){
		return genreService.update(genre);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:genre:remove")
	public R remove( Integer id){
		if(genreService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:genre:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		genreService.batchRemove(ids);
		return R.ok();
	}
	
}
