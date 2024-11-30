package com.example.web_news.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {
    @GetMapping(value = {"Souna", "/", ""})
    public String handleIndex(){
        return "user/index";
    }
}
