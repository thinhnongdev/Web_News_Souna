package com.example.web_news.controller.user;

import com.example.web_news.entity.Article;
import com.example.web_news.service.ArticleService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

@Controller
public class ClientController {
    @Autowired
    ArticleService articleService;
    @GetMapping(value = {"Souna", "/", "","home"})
    public String handleIndex(Model model){
        model.addAttribute("articlesForUser",articleService.getAllArticleForUser());
        return "user/index";
    }
    @GetMapping("/article/detail/{id}")
    public String GetArticleById(@PathVariable("id") String id, Model model){
        model.addAttribute("article",articleService.findByID(id));
        return "user/detailArticle";
    }
    @GetMapping("/search")
    public String SearchArticle(@RequestParam("search") String title, Model model){
        model.addAttribute("search_article",articleService.findByTitle(title));
        return "user/searchArticle";
    }
    @GetMapping("/createnewpost")
    public String GetFormCreateNewArticle( Model model){
        model.addAttribute("newArticle",new Article());
        return "user/formAddArticle";
    }
    @PostMapping("/createnewpost")
    public String CreateNewArticle(@ModelAttribute("newArticle") Article article, Model model){
        model.addAttribute("newArticle",article);
        return "user/index";
    }
}
