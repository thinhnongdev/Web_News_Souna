package com.example.web_news.controller.admin;

import com.example.web_news.dto.request.ArticleCreationRequest;
import com.example.web_news.dto.request.ArticleUpdateRequest;
import com.example.web_news.entity.Article;
import com.example.web_news.entity.Category;
import com.example.web_news.service.ArticleService;
import com.example.web_news.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "admin/article/detailArticle";
    }

    @GetMapping("/article/add")
    public String getFormAdd(Model model) {
        model.addAttribute("article", new Article());
        return "admin/article/formAddArticle";
    }

    @GetMapping("/article/update/{id}")
    public String getFormAddUpdate(@PathVariable("id")  String id, Model model) {
        model.addAttribute("article", articleService.findByID(id));
        return "admin/article/formUpdateArticle";
    }

    @ModelAttribute("categorylist")
    public List<Category> getAllArticle() {
        return categoryService.getAll();
    }

    @PostMapping("/article/create")
    public String createActicle(@ModelAttribute("article") @Valid ArticleCreationRequest createRequest, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("article",createRequest);
            return "admin/article/formAddArticle";
        }
        articleService.add(createRequest);
        return "redirect:/admin/article";
    }

    @PostMapping("/article/update/{id}")
    public String updateActicle(@PathVariable("id") String id,@ModelAttribute("article") @Valid ArticleUpdateRequest updateRequest, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("article",updateRequest);
            return "admin/article/formUpdateArticle";
        }
        articleService.update(id, updateRequest, updateRequest.getCategory().getId());
        return "redirect:/admin/article";
    }

    @GetMapping("/article/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        articleService.deleteById(id);
        return "redirect:/admin/article";
    }
}
