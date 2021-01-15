package com.bootdo.phry.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.bootdo.phry.domain.PactDO;
import com.bootdo.phry.dto.PactDTO;
import com.bootdo.phry.dto.PartyDTO;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.phry.service.PactService;
import com.bootdo.phry.service.UserInfoService;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.service.DeptService;
import com.alibaba.druid.sql.visitor.functions.Now;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-05-27 15:53:38
 */
 
@Controller
@RequestMapping("/phry/pact")
public class PactController {
	
	@Autowired
	private UserInfoService userService;
	@Autowired
	private PactService pactService;
	@Autowired
	private FileService sysFileService;
	@Autowired
	private DeptService deptService;
	
	@GetMapping()
	@RequiresPermissions("phry:pact:pact")
	String Pact(){
	    return "phry/pact/pact";
	}

	//合同到期
	@GetMapping("/pact_expire")
	@RequiresPermissions("phry:pact:expire")
	String expire(){
		return "phry/pact/pact_expire/expire";
	}

	//合同到期-报表
	@GetMapping("/pact_unexpired")
	@RequiresPermissions("phry:pact:unexpired")
	String unexpired(){
		return "phry/pact/pact_expire/unexpired";
	}
	
	
	@GetMapping("/pact_trydate")
	@RequiresPermissions("phry:pact:trydate")
	String trydate(){
	    return "phry/pact/pact_trydate/trydate";
	}
	
	@GetMapping("/onthejob")
	@RequiresPermissions("phry:pact:trydate")
	String onthejob(){
	    return "phry/pact/pact_trydate/onthejob";
	}
	
	//转正
	@GetMapping("/regular")
	@RequiresPermissions("phry:pact:regular")
	String regular(){
	    return "phry/pact/pact_trydate/regular";
	}

	@ResponseBody
	@GetMapping("/expirelist")
	@RequiresPermissions("phry:pact:expire")
	public PageUtils expire(@RequestParam Map<String, Object> params)throws ParseException{
		//查询列表数据
		params.put("workingState", 1);
		params.put("isexpired","1");
		Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		for (PactDTO pactDTO : pactList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String trueDate=pactDTO.getExpirationTime();
			Date dateTime1 = sdf.parse(trueDate);
			Date date=new Date();
			Long difference = dateTime1.getTime() - date.getTime();
			Long days = difference/(1000 * 60 * 60 * 24)+1;
			if (days>0) {
				pactDTO.setLefttime(days.intValue());
			}else {
				pactDTO.setLefttime(0);
			}
		}
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}

	@GetMapping("/addE")
	@RequiresPermissions("phry:pact:isexpired")
	String addE(Integer id , Model model){
		PactDTO pact = pactService.get(id);
		Integer uId=pact.getPersonnelId();
		UserInfoDTO userInfo=userService.get(uId.longValue());
		pact.setDepartment(deptService.get(userInfo.getDeptId()).getName());
		model.addAttribute("pact",pact);
		return "phry/pact/pact_expire/add2";
	}

	@GetMapping("/addE2")
	@RequiresPermissions("phry:pact:isexpired")
	String addE2(Integer id , Model model){
		PactDTO pact = pactService.get(id);
		Integer uId=pact.getPersonnelId();
		UserInfoDTO userInfo=userService.get(uId.longValue());
		pact.setDepartment(deptService.get(userInfo.getDeptId()).getName());
		model.addAttribute("pact",pact);
		return "phry/pact/pact_expire/add";
	}
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveE")
	@RequiresPermissions("phry:pact:isexpired")
	public R saveE( PactDTO pact){
		PactDTO opact=new PactDTO();
		opact.setId(pact.getId());
		opact.setWorkingState(3);
		pactService.update(opact);

		pact.setWorkingState(1);
		pact.setId(null);
		return pactService.save(pact);
	}

	/**
	 * 合同到期
	 */
	@PostMapping( "/expiredate")
	@ResponseBody
	@RequiresPermissions("phry:pact:isexpired")
	public R expiredate(@RequestParam("ids[]") Integer[] ids){
		for (Integer integer : ids) {
			PactDTO pact=new PactDTO();
			pact.setId(integer);
			pact.setWorkingState(4);
			pactService.update(pact);
		}

		return R.ok();
	}

	//合同到期-报表
	@ResponseBody
	@GetMapping("/unexpiredList")
	@RequiresPermissions("phry:pact:unexpired")
	public PageUtils unexpiredList(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("expiredState", "1");
		Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/regularList")
	@RequiresPermissions("phry:pact:regular")
	public PageUtils regularList(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("workingState", 1);
        Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/trylist")
	@RequiresPermissions("phry:pact:trydate")
	public PageUtils trylist(@RequestParam Map<String, Object> params)throws ParseException{
		//查询列表数据	
		params.put("workingState", 0);
        Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		for (PactDTO pactDTO : pactList) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String trueDate=pactDTO.getProbationPeriod();
			Date dateTime1 = sdf.parse(trueDate);
			Date date=new Date();
			Long difference = dateTime1.getTime() - date.getTime();
			Long days = difference/(1000 * 60 * 60 * 24)+1;
			if (days>0) {
				pactDTO.setProbationDate(days.intValue());
			}else {
				pactDTO.setProbationDate(0);
			}
		}
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("phry:pact:pact")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PactDTO> pactList = pactService.list(query);
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/golist")
	@RequiresPermissions("phry:pact:pact")
	public PageUtils golist(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("workingState", 1);
        Query query = new Query(params);
        
		List<PactDTO> pactList = pactService.list(query);
		int total = pactService.count(query);
		PageUtils pageUtils = new PageUtils(pactList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("phry:pact:add")
	String add(){
	    return "phry/pact/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("phry:pact:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PactDTO pact = pactService.get(id);
		/*FileDO fileDO = sysFileService.get((pact.getFileId()).longValue());
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
		}*/
	/*	model.addAttribute("fileDO",fileDO);*/
		
	

	

		String[] fileIds = pact.getFileId().split(",");
		List<FileDO> fileDOS = new ArrayList<>();
		for (String fileId:fileIds) {
			if(!"".equals(fileId)) {
				fileDOS.add(sysFileService.get(Long.parseLong(fileId)));
			}
		}
		pact.setFileDOList(fileDOS);
		
		
		
		model.addAttribute("pact", pact);
	    return "phry/pact/edit";
	}
	
	@GetMapping("/worker/{id}")
	@RequiresPermissions("phry:pact:worker")
	String worker(@PathVariable("id") Integer id,Model model){
		PactDTO pact = pactService.get(id);
		
		model.addAttribute("pact", pact);
	    return "phry/pact/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("phry:pact:add")
	public R save( PactDTO pact){
		pact.setWorkingState(0);
		return pactService.save(pact);
	}
	
	@GetMapping("/pactInfo/{id}")
	String pactInfo(Model model,@PathVariable("id") Integer id){
		PactDTO pact = pactService.get(id);
	/*	FileDO fileDO = sysFileService.get(pact.getFileId().longValue());
		if(fileDO==null){
			fileDO = new FileDO();
			fileDO.setUrl("/img/backg01.jpg");
		}
		model.addAttribute("fileDO",fileDO);*/
		model.addAttribute("pact",pact);
		return "phry/pact/pactInfo";
	}
	//显示文件
	@GetMapping("/showFiles/{fileIdList}")
	String showFiles(@PathVariable("fileIdList") String fileIdList,Model model){

		String[] fileIds = fileIdList.split(",");
		List<FileDO> fileDOImgList = new ArrayList<>();
		List<FileDO> fileDODocList = new ArrayList<>();

		for (String fileId:fileIds) {
			FileDO fileDO = sysFileService.get(Long.parseLong(fileId));
			if(fileDO.getType()==0) {
				fileDOImgList.add(fileDO);
			}else{
				fileDODocList.add(fileDO);
			}
		}
		model.addAttribute("fileDOImgList",fileDOImgList);
		model.addAttribute("fileDODocList",fileDODocList);
		return "phry/userinfo/userinfo/showFiles";
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("phry:pact:edit")
	public R update( PactDTO pact){
		return pactService.update(pact);
	}
	
	/**
	 * 合同转正
	 */
	@PostMapping( "/changeStyle")
	@ResponseBody
	@RequiresPermissions("phry:pact:worker")
	public R changeStyle(@RequestParam("ids[]") Integer[] ids){
		for (Integer integer : ids) {
			PactDTO pact=new PactDTO();
			pact.setId(integer);	
			pact.setWorkingState(1);
			pactService.update(pact);
		}
		
		return R.ok();
	}
	
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("phry:pact:remove")
	public R remove( Integer id){
		if(pactService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("phry:pact:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		pactService.batchRemove(ids);
		return R.ok();
	}
	
	
	/**
	 * 突然离职
	 */
	@PostMapping( "/doDeparture")
	@ResponseBody
	@RequiresPermissions("phry:pact:worker")
	public R doDeparture(@RequestParam("ids[]") Integer[] ids){
		for (Integer integer : ids) {
			PactDTO pact=new PactDTO();
			pact.setId(integer);	
			pact.setWorkingState(2);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String now=df.format(new Date());
			pact.setResignationTime(now);
			pactService.update(pact);
		}
		
		return R.ok();
	}
	/**
	 * 转岗
	 * @param id
	 * @param model
	 * @return
	 */
	
	@GetMapping("/jobTransfer/{id}")
	@RequiresPermissions("phry:pact:edit")
	String jobTransfer(@PathVariable("id") Integer id,Model model){
		PactDTO pact = pactService.get(id);
		UserInfoDTO user = userService.get(pact.getPersonnelId().longValue());
		DeptDO deptDO = deptService.get(user.getDeptId());
		if(deptDO!=null){
			user.setDeptName(deptDO.getName());
		}
		model.addAttribute("user", user);
		model.addAttribute("pact", pact);
	    return "phry/pact/pact_trydate/jobTransfer";
	}
	
	/**
	 * 转岗
	 */
	@ResponseBody
	@RequestMapping("/updateTransfer")
	@RequiresPermissions("phry:pact:edit")
	public R updateTransfer( PactDTO pact,UserInfoDTO user){
		pact.setDepartment(user.getDeptName());
		return pactService.update(pact);
	}
	
}
