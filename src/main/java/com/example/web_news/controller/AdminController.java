package com.example.web_news.controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping(value = {"/index","/",""})
    public String handleIndex(){
        return "admin/index";
    }
}
