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

import com.bootdo.phry.domain.RetireDO;
import com.bootdo.phry.dto.RetireDTO;
import com.bootdo.phry.service.RetireService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 缴纳党费信息录入
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-11 10:06:33
 */
 
@Controller
@RequestMapping("/phry/retire")
public class RetireController {
	@Autowired
	private RetireService retireService;
	
	@GetMapping()
	@RequiresPermissions("phry:retire:retire")
	String Retire(){
	    return "phry/retire/retire";
	}
	
	@GetMapping("retireReport")
	@RequiresPermissions("phry:retire:listReport")
	String RetireReport(){
	    return "phry/retire/retireReport/retireReport";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:retire:retire")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RetireDTO> retireList = retireService.list(query);
		int total = retireService.count(query);
		PageUtils pageUtils = new PageUtils(retireList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listReport")
	@RequiresPermissions("phry:retire:listReport")
	public PageUtils listReport(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RetireDTO> retireList = retireService.list2(query);
		int total = retireService.count2(query);
		PageUtils pageUtils = new PageUtils(retireList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:retire:add")
	String add(){
	    return "phry/retire/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:retire:edit")
	String edit(@PathVariable("id") Long id,Model model){
		RetireDTO retire = retireService.get(id);
		model.addAttribute("retire", retire);
	    return "phry/retire/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:retire:add")
	public R save( RetireDTO retire){
		return retireService.save(retire);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:retire:edit")
	public R update( RetireDTO retire){
		return retireService.update(retire);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:retire:remove")
	public R remove( Long id){
		if(retireService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:retire:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		retireService.batchRemove(ids);
		return R.ok();
	}
	
}
