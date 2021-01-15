package com.bootdo.phry.controller;

import com.bootdo.common.utils.R;
import com.bootdo.phry.dto.UserInfoDTO;
import com.bootdo.phry.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/phry/agereport")
public class AgereportController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("")
    String Party(@RequestParam Map<String, Object> params, Model model){

        return "phry/agereport/agereport";
    }



    @ResponseBody
    @RequestMapping("/getreport")
    public R getreport(){
        Map<String, Object> map = new HashMap<>();
        int a1 = userInfoService.age1();
        int a2 = userInfoService.age2();
        int a3 = userInfoService.age3();
        int a4 = userInfoService.age4();
        int a5 = userInfoService.age5();
        int a6 = userInfoService.age6();
        return R.ok().put("a1", a1).put("a2", a2).put("a3", a3).put("a4", a4).put("a5", a5).put("a6", a6);
    }

}
