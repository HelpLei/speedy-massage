package com.bootdo.system.controller;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.domain.Tree;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;
import com.bootdo.system.dao.UserLoginDao;
import com.bootdo.system.domain.MenuDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.domain.UserLoginDO;
import com.bootdo.system.domain.UserToken;
import com.bootdo.system.service.MenuService;
import com.bootdo.system.service.UserService;
import com.sun.tools.internal.ws.processor.model.Request;

import io.swagger.models.auth.In;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserLoginDao userMapper;
    @Autowired
    MenuService menuService;
    @Autowired
    FileService fileService;
    @Autowired
    BootdoConfig bootdoConfig;
    @Autowired
    private UserService userService;

    @GetMapping({"/", ""})
    String welcome(Model model) {

        return "redirect:/login";
    }

    @Log("请求访问主页")
    @GetMapping({"/index"})
    String index(Model model) {
        List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("name", getUser().getUsername());
        FileDO fileDO = fileService.get(0l);
        if (fileDO != null && fileDO.getUrl() != null) {
            if (fileService.isExist(fileDO.getUrl())) {
                model.addAttribute("picUrl", fileDO.getUrl());
            } else {
                model.addAttribute("picUrl", "/img/dang.jpg");
            }
        } else {
            model.addAttribute("picUrl", "/img/dang.jpg");
        }
        
        if (getUser().getUsername().equals("潘黄党组织部门")) {
			
    	    return "phry/onlyParty/onlyParty2"; 
		}else if(getUser().getUsername().equals("潘黄党员")){
			  
	        model.addAttribute("username", getUser().getUsername());
	        return "phry/onlyParty/onlyParty2"; 

		}
        else {
			  
	        model.addAttribute("username", getUser().getUsername());
	        return "index_v1";

		}
       
    }

    @GetMapping("/login")
    String login(Model model,HttpServletRequest request) {
    	String ua = request.getHeader("user-agent").toLowerCase();
    	if (ua.indexOf("micromessenger") > 0) {
    		//微信登陆
    		   return "phry/weixin/login";
    	}
        model.addAttribute("username", bootdoConfig.getUsername());
        model.addAttribute("password", bootdoConfig.getPassword());
        return "login";
    }

    @Log("登录")
    @PostMapping("/login")
    @ResponseBody
    R ajaxLogin(String username, String password,String verify,HttpServletRequest request) {
     	if (verify != null) {
        try {
            //从session中获取随机数
            String random = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if (StringUtils.isBlank(verify)) {
                return R.error("请输入验证码");
            }
            if (random.equals(verify)) {
            } else {
                return R.error("请输入正确的验证码");
            }
        } catch (Exception e) {
            logger.error("验证码校验失败", e);
            return R.error("验证码校验失败");
        }
     	}
        Map<String,Object> map=new HashMap<>();
        map.put("name",username);
        List<UserLoginDO> userList=userService.getById(map);
        if (userList.size() == 0) {
            return R.error("账号密码错误");
        }
        else{
            //获得登录失败的次数
            int intMissNumber = userList.get(0).getMissNumber();

            int intUserId = Math.toIntExact(userList.get(0).getUserId());

            //获得该用户上一次登录的时间
            Date dateLogin = userList.get(0).getMissTime();

            //获得允许登录时间的字段:allow_time
            Date dateAllowTime = userList.get(0).getAllowTime();

            //获得当前时间
            Date dateNow = new Date();

            Map<String,Object> map1=new HashMap<>();
            map1.put("username",username);
            password = MD5Utils.encrypt(username, password);
            map1.put("password",password);
            int num = userService.selectByNamePassword(map1);


            //如果该时间允许登录
            //如果现在的时间大于允许登录的时间
            if (dateAllowTime == null ||dateNow.getTime() > dateAllowTime.getTime()) {

                //begin:对错误登录次数的判断
                //判断错误次数是否大于等于3
                if (intMissNumber >= 3 ) {
                    //已经登录失败了三次及以上，锁定账号，不允许登录
                    //允许登录的时间加2分钟
                    logger.info("允许登录的时间没有加2分钟前是:"+dateAllowTime);
                    Date dateAfterAllowTime = new Date(dateNow .getTime() + 1800000);
                    logger.info("允许登录的时间加2分钟后是:"+dateAfterAllowTime);
                    //修改数据库中的miss_number错误记录的数目
                    //把错误次数清0
                    intMissNumber = 0;
                    UserLoginDO user = new UserLoginDO();
                    user.setUserId((long) intUserId);
                    user.setMissNumber(intMissNumber);
                    user.setAllowTime(dateAfterAllowTime);
                    int intFlag = userService.update1(user);
                    logger.info("intFlag:"+intFlag);
                    logger.info("222时间允许登录，但是错误次数超过三次！");
                   return R.error("已错误三次，请在三十分钟后再登录");

                    //错误次数小于三次，可以登录
                }else {

                    //begin:对密码是否正确的判断
                    //如果密码对了
                    if (num != 0) {
                        //把错误次数清0
                        intMissNumber = 0;
                        //记录最新登录的时间
                        dateLogin = new Date();
                        //记录最新的允许登录时间
                        dateAllowTime = new Date();

                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissTime(dateLogin);
                        user.setMissNumber(intMissNumber);
                        user.setAllowTime(dateAllowTime);

                        int intFlag = userService.update1(user);
                        logger.info("intFlag:"+intFlag);
                        //把id保存进session，在后面的文章发表、评论发表时候会用到
                        HttpSession session = request.getSession();
                        session.setAttribute("intUserId", intUserId);

                        //begin:拦截器所需
                        session.setAttribute("userList", userList);
                        //end:拦截器所需
                        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                        Subject subject = SecurityUtils.getSubject();

                            subject.login(token);
                        SecurityUtils.getSubject().getSession().setTimeout(500000);
                            return R.ok();


                        //如果密码错了
                    }else {
                        //把错误次数+1
                        intMissNumber = intMissNumber + 1;
                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissNumber(intMissNumber);
                        int intFlag = userService.update1(user);
                        logger.info("密码错误的intFlag:"+intFlag);

                      return R.error("账号密码错误");
                    }
                    //end:对密码是否正确的判断
                }
                //end:错误登录次数的判断

                //该时间不允许登录
            }else {
                logger.info("111对时间的判断结果：当前时间不允许登录!");
                return R.error("已错误三次，请稍后再登录");
            }

            //end:对能否登录时间的判断
        }
    }

    @Log("微信登录")
    @PostMapping("/login3")
    @ResponseBody
    R ajaxLogin2(String username, String password,HttpServletRequest request) {
     
        Map<String,Object> map=new HashMap<>();
        map.put("name",username);
        List<UserLoginDO> userList=userService.getById(map);
        if (userList.size() == 0) {
            return R.error("账号密码错误");
        }
        else{
            //获得登录失败的次数
            int intMissNumber = userList.get(0).getMissNumber();

            int intUserId = Math.toIntExact(userList.get(0).getUserId());

            //获得该用户上一次登录的时间
            Date dateLogin = userList.get(0).getMissTime();

            //获得允许登录时间的字段:allow_time
            Date dateAllowTime = userList.get(0).getAllowTime();

            //获得当前时间
            Date dateNow = new Date();

            Map<String,Object> map1=new HashMap<>();
            map1.put("username",username);
            password = MD5Utils.encrypt(username, password);
            map1.put("password",password);
            int num = userService.selectByNamePassword(map1);


            //如果该时间允许登录
            //如果现在的时间大于允许登录的时间
            if (dateAllowTime == null ||dateNow.getTime() > dateAllowTime.getTime()) {

                //begin:对错误登录次数的判断
                //判断错误次数是否大于等于3
                if (intMissNumber >= 3 ) {
                    //已经登录失败了三次及以上，锁定账号，不允许登录
                    //允许登录的时间加2分钟
                    logger.info("允许登录的时间没有加2分钟前是:"+dateAllowTime);
                    Date dateAfterAllowTime = new Date(dateNow .getTime() + 1800000);
                    logger.info("允许登录的时间加2分钟后是:"+dateAfterAllowTime);
                    //修改数据库中的miss_number错误记录的数目
                    //把错误次数清0
                    intMissNumber = 0;
                    UserLoginDO user = new UserLoginDO();
                    user.setUserId((long) intUserId);
                    user.setMissNumber(intMissNumber);
                    user.setAllowTime(dateAfterAllowTime);
                    int intFlag = userService.update1(user);
                    logger.info("intFlag:"+intFlag);
                    logger.info("222时间允许登录，但是错误次数超过三次！");
                   return R.error("已错误三次，请在三十分钟后再登录");

                    //错误次数小于三次，可以登录
                }else {

                    //begin:对密码是否正确的判断
                    //如果密码对了
                    if (num != 0) {
                        //把错误次数清0
                        intMissNumber = 0;
                        //记录最新登录的时间
                        dateLogin = new Date();
                        //记录最新的允许登录时间
                        dateAllowTime = new Date();

                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissTime(dateLogin);
                        user.setMissNumber(intMissNumber);
                        user.setAllowTime(dateAllowTime);

                        int intFlag = userService.update1(user);
                        logger.info("intFlag:"+intFlag);
                        //把id保存进session，在后面的文章发表、评论发表时候会用到
                        HttpSession session = request.getSession();
                        session.setAttribute("intUserId", intUserId);

                        //begin:拦截器所需
                        session.setAttribute("userList", userList);
                        //end:拦截器所需
                        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                        Subject subject = SecurityUtils.getSubject();

                            subject.login(token);
                        SecurityUtils.getSubject().getSession().setTimeout(500000);
                            return R.ok();


                        //如果密码错了
                    }else {
                        //把错误次数+1
                        intMissNumber = intMissNumber + 1;
                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissNumber(intMissNumber);
                        int intFlag = userService.update1(user);
                        logger.info("密码错误的intFlag:"+intFlag);

                      return R.error("账号密码错误");
                    }
                    //end:对密码是否正确的判断
                }
                //end:错误登录次数的判断

                //该时间不允许登录
            }else {
                logger.info("111对时间的判断结果：当前时间不允许登录!");
                return R.error("已错误三次，请稍后再登录");
            }

            //end:对能否登录时间的判断
        }
    }
    
    
    @GetMapping("/logout")
    String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    @GetMapping("/main")
    String main() {
        return "main";
    }

    /**
     * 生成验证码
     */
    @GetMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            logger.error("获取验证码失败>>>> ", e);
        }
    }
    @Log("修改密码")
    @PostMapping("/changeLogin")
    @ResponseBody
    R ajaxChangeLogin(String username, String password,String newpassword2,String newpassword3,HttpServletRequest request,UserLoginDO userDO)throws Exception  {
	  if (!newpassword2.equals(newpassword3)) {
		  return R.error("新账号两次输入不一致！请重新输入");
	}
        Map<String,Object> map=new HashMap<>();
        map.put("name",username);
        List<UserLoginDO> userList=userService.getById(map);
        if (userList.size() == 0) {
            return R.error("原账号密码错误");
        }
        else{
            //获得登录失败的次数
            int intMissNumber = userList.get(0).getMissNumber();

            int intUserId = Math.toIntExact(userList.get(0).getUserId());

            //获得该用户上一次登录的时间
            Date dateLogin = userList.get(0).getMissTime();

            //获得允许登录时间的字段:allow_time
            Date dateAllowTime = userList.get(0).getAllowTime();

            //获得当前时间
            Date dateNow = new Date();

            Map<String,Object> map1=new HashMap<>();
            map1.put("username",username);
            password = MD5Utils.encrypt(username, password);
            map1.put("password",password);
            int num = userService.selectByNamePassword(map1);


            //如果该时间允许登录
            //如果现在的时间大于允许登录的时间
            if (dateAllowTime == null ||dateNow.getTime() > dateAllowTime.getTime()) {

                //begin:对错误登录次数的判断
                //判断错误次数是否大于等于3
                if (intMissNumber >= 3 ) {
                    //已经登录失败了三次及以上，锁定账号，不允许登录
                    //允许登录的时间加2分钟
                    logger.info("允许登录的时间没有加2分钟前是:"+dateAllowTime);
                    Date dateAfterAllowTime = new Date(dateNow .getTime() + 1800000);
                    logger.info("允许登录的时间加2分钟后是:"+dateAfterAllowTime);
                    //修改数据库中的miss_number错误记录的数目
                    //把错误次数清0
                    intMissNumber = 0;
                    UserLoginDO user = new UserLoginDO();
                    user.setUserId((long) intUserId);
                    user.setMissNumber(intMissNumber);
                    user.setAllowTime(dateAfterAllowTime);
                    int intFlag = userService.update1(user);
                    logger.info("intFlag:"+intFlag);
                    logger.info("222时间允许登录，但是错误次数超过三次！");
                   return R.error("已错误三次，请在三十分钟后再登录");

                    //错误次数小于三次，可以登录
                }else {

                    //begin:对密码是否正确的判断
                    //如果密码对了
                    if (num != 0) {
                        //把错误次数清0
                        intMissNumber = 0;
                        //记录最新登录的时间
                        dateLogin = new Date();
                        //记录最新的允许登录时间
                        dateAllowTime = new Date();

                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissTime(dateLogin);
                        user.setMissNumber(intMissNumber);
                        user.setAllowTime(dateAllowTime);

                        int intFlag = userService.update1(user);
                        logger.info("intFlag:"+intFlag);
                        //把id保存进session，在后面的文章发表、评论发表时候会用到
                        HttpSession session = request.getSession();
                        session.setAttribute("intUserId", intUserId);

                        //begin:拦截器所需
                        session.setAttribute("userList", userList);
                        //end:拦截器所需
                        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                        Subject subject = SecurityUtils.getSubject();

                            subject.login(token);
                        SecurityUtils.getSubject().getSession().setTimeout(500000);
                        
                        userDO.setUserId(userList.get(0).getUserId());
                        userDO.setPassword(MD5Utils.encrypt(username,newpassword2));
                         userMapper.update(userDO);
                            return R.ok();


                        //如果密码错了
                    }else {
                        //把错误次数+1
                        intMissNumber = intMissNumber + 1;
                        //修改数据库中的miss_number错误记录的数目
                        UserLoginDO user = new UserLoginDO();
                        user.setUserId((long) intUserId);
                        user.setMissNumber(intMissNumber);
                        int intFlag = userService.update1(user);
                        logger.info("密码错误的intFlag:"+intFlag);

                      return R.error("账号密码错误");
                    }
                    //end:对密码是否正确的判断
                }
                //end:错误登录次数的判断

                //该时间不允许登录
            }else {
                logger.info("111对时间的判断结果：当前时间不允许登录!");
                return R.error("已错误三次，请稍后再登录");
            }

            //end:对能否登录时间的判断
        }

    }
}
