package com.bootdo.system.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.DeptInstitutionDO;
import com.bootdo.system.service.DeptInstitutionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机构管理
 * 
 * @author zplxshb
 * @email 123456789@qq.com
 * @date 2019-06-03 17:34:20
 */
 
@Controller
@RequestMapping("/system/deptInstitution")
public class DeptInstitutionController extends BaseController{
	private String prefix = "system/institute";
	@Autowired
	private DeptInstitutionService deptInstitutionService;
	
	@GetMapping()
	@RequiresPermissions("system:institute:institute")
	String DeptInstitution(){
		return prefix + "/dept";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:institute:institute")
	public List<DeptInstitutionDO> list(){
		Map<String, Object> query = new HashMap<>(16);
		List<DeptInstitutionDO> sysDeptList = deptInstitutionService.list(query);
		return sysDeptList;
	}

	@GetMapping("/add/{pId}")
	@RequiresPermissions("system:institute:add")
	String add(@PathVariable("pId") Long pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "总机构");
		} else {
			model.addAttribute("pName", deptInstitutionService.get(pId).getName());
		}
		return  prefix + "/add";
	}

	@GetMapping("/edit/{deptId}")
	@RequiresPermissions("system:institute:edit")
	String edit(@PathVariable("deptId") Long deptId, Model model) {
		DeptInstitutionDO sysDept = deptInstitutionService.get(deptId);
		model.addAttribute("sysDept", sysDept);
		if(Constant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
			model.addAttribute("parentDeptName", "无");
		}else {
			DeptInstitutionDO parDept = deptInstitutionService.get(sysDept.getParentId());
			model.addAttribute("parentDeptName", parDept.getName());
		}
		return  prefix + "/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:institute:add")
	public R save(DeptInstitutionDO sysDept) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (deptInstitutionService.save(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:institute:edit")
	public R update(DeptInstitutionDO sysDept) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (deptInstitutionService.update(sysDept) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:institute:remove")
	public R remove(Long deptId) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", deptId);
		if(deptInstitutionService.count(map)>0) {
			return R.error(1, "包含下级机构,不允许修改");
		}
		if(deptInstitutionService.checkDeptHasUser(deptId)) {
			if (deptInstitutionService.remove(deptId) > 0) {
				return R.ok();
			}
		}else {
			return R.error(1, "机构包含用户,不允许修改");
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:institute:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] deptIds) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		deptInstitutionService.batchRemove(deptIds);
		return R.ok();
	}

	@GetMapping("/tree")
	@ResponseBody
	public Tree<DeptInstitutionDO> tree() {
		Tree<DeptInstitutionDO> tree = new Tree<DeptInstitutionDO>();
		tree = deptInstitutionService.getTree();
		return tree;
	}

	@GetMapping("/treeView")
	String treeView() {
		return  prefix + "/deptTree";
	}
}
