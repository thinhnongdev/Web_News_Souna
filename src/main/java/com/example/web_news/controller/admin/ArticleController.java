package com.example.web_news.controller.admin;

import com.example.web_news.entity.Article;
import com.example.web_news.entity.Category;
import com.example.web_news.service.ArticleService;
import com.example.web_news.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/article/details/{id}")
    public String findById(@PathVariable("id") String id, Model model) {
        model.addAttribute("article_preview", articleService.findByID(id));
        return "admin/detailNews";
    }
    @GetMapping("/article/add")
    public String getFormAdd(Model model) {
        model.addAttribute("article",new Article());
        return "admin/formAddCategory";
    } 
    @GetMapping("/article/update/{id}")
    public String getFormAddUpdate(@PathVariable("id") String id,Model model) {
        model.addAttribute("article",articleService.findByID(id));
        return "admin/formUpdateCategory";
    }
    @GetMapping("/article/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        articleService.deleteById(id);
        return "redirect:/admin/article";
    }
    @ModelAttribute("categorylist")
    public List<Category> getAllArticle() {
        return categoryService.getAll();
    }
    @PostMapping("/article/create")
    public String createActicle(@ModelAttribute("article")Article article) {
        articleService.add(article,article.getCategory().getId());
        return "redirect:/admin/article";
    }
    @PostMapping("/article/update/{id}")
    public String updateActicle(@ModelAttribute("article")Article article,@PathVariable("id") String id) {
        articleService.updateArticle(id,article,article.getCategory().getId());
        return "redirect:/admin/article";
    }

}
