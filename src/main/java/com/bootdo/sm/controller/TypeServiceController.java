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

import com.bootdo.sm.domain.TypeServiceDO;
import com.bootdo.sm.dto.TypeServiceDTO;
import com.bootdo.sm.service.TypeServiceService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 服务类型
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2021-01-15 15:40:05
 */
 
@Controller
@RequestMapping("/sm/typeService")
public class TypeServiceController {
	@Autowired
	private TypeServiceService typeServiceService;
	
	@GetMapping()
	@RequiresPermissions("phry:typeService:typeService")
	String TypeService(){
	    return "phry/typeService/typeService";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:typeService:typeService")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TypeServiceDTO> typeServiceList = typeServiceService.list(query);
		int total = typeServiceService.count(query);
		PageUtils pageUtils = new PageUtils(typeServiceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:typeService:add")
	String add(){
	    return "phry/typeService/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:typeService:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TypeServiceDTO typeService = typeServiceService.get(id);
		model.addAttribute("typeService", typeService);
	    return "phry/typeService/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:typeService:add")
	public R save( TypeServiceDTO typeService){
		return typeServiceService.save(typeService);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:typeService:edit")
	public R update( TypeServiceDTO typeService){
		return typeServiceService.update(typeService);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:typeService:remove")
	public R remove( Integer id){
		if(typeServiceService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:typeService:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		typeServiceService.batchRemove(ids);
		return R.ok();
	}
	
}
