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
@RequestMapping("/phry/workreport")
public class WorkreportController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("")
    String Party(@RequestParam Map<String, Object> params, Model model){

        return "phry/workreport/workreport";
    }

//select groupby出来的几种结果 for循环这集中结果

    @ResponseBody
    @RequestMapping("/getreport")
    public R getreport(){

        int a1 = userInfoService.work1();
        int a2 = userInfoService.work2();
        int a3 = userInfoService.work3();
        int a4 = userInfoService.work4();
        return R.ok().put("a1", a1).put("a2", a2).put("a3", a3).put("a4", a4);
    }

}
