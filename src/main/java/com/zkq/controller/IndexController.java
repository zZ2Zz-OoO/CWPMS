package com.zkq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //使用thymeleaf渲染首页
    @RequestMapping("/")
    public String index() {
        return "ManagerLogin.html";
    }
}
