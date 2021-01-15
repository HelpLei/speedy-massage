package com.bootdo.phry.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.bootdo.phry.dto.LeaveDTO;
import com.bootdo.phry.dto.PactDTO;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.phry.service.LeaveService;
import com.bootdo.phry.service.PactService;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.system.service.DeptService;
import com.bootdo.common.enums.UserType;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 请假表
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 10:23:55
 */
 
@Controller
@RequestMapping("/phry/leave")
public class LeaveController {
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private PactService pactService;
	
	@Autowired
	private UserInfoService userService;
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping()
	@RequiresPermissions("phry:leave:leave")
	String Leave(){
	    return "phry/leave/leave";
	}
	
	@ResponseBody
	@GetMapping("/list2")
	
	public PageUtils list2(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/list3")
	
	public PageUtils list3(@RequestParam Map<String, Object> params){
		//查询列表数据
				params.put("isOwner", UserType.录入人员.getCode());
				params.put("status", 1);
		        Query query = new Query(params);
		       
				List<UserInfoDTO> userList = userService.list(query);
				userList.forEach(e->{
					e.setDeptDO(deptService.get(e.getDeptId()));
				});
				int total = userService.count(query);
				PageUtils pageUtils = new PageUtils(userList, total);
				return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:leave:leave")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LeaveDTO> leaveList = leaveService.list(query);
		int total = leaveService.count(query);
		PageUtils pageUtils = new PageUtils(leaveList, total);
		return pageUtils;
	}
	
	@GetMapping("/leaveName")
	@RequiresPermissions("phry:leave:add")
	String leaveName(){
	    return "phry/leave/leaveName";
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:leave:add")
	String add(Model model){
		
		Integer style=1;
		model.addAttribute("style", style);
		
	    return "phry/leave/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:leave:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LeaveDTO leave = leaveService.get(id);
		model.addAttribute("leave", leave);
	    return "phry/leave/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:leave:add")
	public R save( LeaveDTO leave)throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=leave.getEndTime();
		String date2=leave.getLeaveTime();
		
			Date dateTime1 = sdf.parse(date);
			Date dateTime2 = sdf.parse(date2);

			long difference = dateTime1.getTime() - dateTime2.getTime();
			
			long days = difference/(1000 * 60 * 60 * 24)+1;
			
			leave.setLeaveDate(String.valueOf(days));
			
		return leaveService.save(leave);
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:leave:edit")
	public R update( LeaveDTO leave)throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=leave.getEndTime();
		String date2=leave.getLeaveTime();
			Date dateTime1 = sdf.parse(date);
			Date dateTime2 = sdf.parse(date2);
			long difference = dateTime1.getTime() - dateTime2.getTime();
			if (difference<0) {
				return R.error("开始请假时间不能大于请假后时间");
			}
			long days = difference/(1000 * 60 * 60 * 24)+1;
			leave.setLeaveDate(String.valueOf(days));
		return leaveService.update(leave);
	}
	
	/**
	 * 新增
	 */
	@ResponseBody
	@RequestMapping("/update2")
	@RequiresPermissions("phry:leave:edit")
	public R update2( LeaveDTO leave){
		return leaveService.save(leave);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:leave:remove")
	public R remove( Integer id){
		if(leaveService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:leave:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		leaveService.batchRemove(ids);
		return R.ok();
	}
	
	
	/**
	 * 选择人员
	 */
	@PostMapping( "/updateTrue")
	@ResponseBody
	public String updateTrue(Integer id,Model model){
		PactDTO pact = pactService.get(id);
		
		LeaveDTO leave = new LeaveDTO();
		leave.setName(pact.getName());
		leave.setDepartment(pact.getDepartment());
		leave.setPactId(pact.getId());
		leave.setPost(pact.getPost());
		 model.addAttribute("leave", leave);
		  return "phry/leave/edit";
	}
	
	
	@GetMapping("/edit2/{id}")
	String edit2(@PathVariable("id") Integer id,Model model){
		PactDTO pact = pactService.get(id);
		LeaveDTO leave = new LeaveDTO();
		leave.setName(pact.getName());
		leave.setDepartment(pact.getDepartment());
		leave.setPactId(pact.getId());
		leave.setPost(pact.getPost());
		 model.addAttribute("leave", leave);
	    return "phry/leave/edit";
	}
	
	
	
	
	
	
	
	
}
