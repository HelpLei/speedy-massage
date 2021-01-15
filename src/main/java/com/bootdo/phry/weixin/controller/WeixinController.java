
package com.bootdo.phry.weixin.controller;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.enums.DeptSelect;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.service.DeptService;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {

	@Autowired
	private DeptService sysDeptService;


// --------------------------------------------   主页部分  -------------------------------------------------------------------------

    /**
     * 公众号登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "phry/weixin/login.html";
    }

    /**
     * 公众号主页面
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
    	Map<String, Object> query = new HashMap<>();
    	List<DeptDO> sysDeptList = sysDeptService.list(query);
    	String name=sysDeptList.get(0).getName();
    	model.addAttribute("name", name);
    	model.addAttribute("sysDeptList", sysDeptList);
    	
        return "phry/weixin/index.html";
    }


    /**
     * 公众号右侧滑动块
     * @return
     */
    @RequestMapping("/rightSide")
    public String rightSide(){
        return "phry/weixin/rightSide.html";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "phry/weixin/login.html";
    }



 

 

   

}
