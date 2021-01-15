package com.bootdo.phry.controller;

import com.bootdo.common.utils.R;
import com.bootdo.phry.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/phry/studyreport")
public class StudyreportController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("")
    String Party(@RequestParam Map<String, Object> params, Model model){

        return "phry/studyreport/studyreport";
    }



    @ResponseBody
    @RequestMapping("/getreport")
    public R getreport(){
        Map<String, Object> map = new HashMap<>();
        int a1 = userInfoService.study1();
        int a2 = userInfoService.study2();
        int a3 = userInfoService.study3();
        int a4 = userInfoService.study4();
        int a5 = userInfoService.study5();
        int a6=userInfoService.study6();
        return R.ok().put("a1", a1).put("a2", a2).put("a3", a3).put("a4", a4).put("a5", a5).put("a6",a6);
    }

}
