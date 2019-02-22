package com.springMvc.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping("welcome")
    public String display(){
        return "insert";
    }
}
