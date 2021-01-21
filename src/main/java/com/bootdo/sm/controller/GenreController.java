package com.bootdo.sm.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.sm.dto.GenreDTO;
import com.bootdo.sm.service.GenreService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
	    return "sm/genre/genre";
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
	    return "sm/genre/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:genre:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		GenreDTO genre = genreService.get(id);
		model.addAttribute("genre", genre);
	    return "sm/genre/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:genre:add")
	public R save( GenreDTO genre){
		genre.setType(0);
		return genreService.save(genre);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:genre:edit")
	public R update( GenreDTO genre){
		genre.setType(0);
		return genreService.update(genre);
	}
	
	/**
	 * 查看
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:genre:remove")
	public R remove( Integer id){
		GenreDTO genre= new GenreDTO();
		genre.setId(id);
		genre.setType(1);
		genreService.update(genre);
			return R.ok();

	}
	/**
	 * 查看
	 */
	@PostMapping( "/remove2")
	@ResponseBody
	@RequiresPermissions("phry:genre:remove")
	public R remove2( Integer id){
		GenreDTO genre= new GenreDTO();
		genre.setId(id);
		genre.setType(0);
		genreService.update(genre);
		return R.ok();

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
