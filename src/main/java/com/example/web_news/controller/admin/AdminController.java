package com.example.web_news.controller.admin;

import com.example.web_news.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    ArticleService articleService;
    @GetMapping(value = {"dashboard", "/", ""})
    public String handleIndex() {
        return "admin/index";
    }

    @GetMapping("/category")
    public String handleCategory() {
        return "admin/category";
    }

    @GetMapping("/article")
    public String handleArticle(Model model) {
        model.addAttribute("list_article", articleService.getAllArticle());
        return "admin/article";
    }



}
