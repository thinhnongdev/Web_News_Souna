package com.example.web_news.controller.admin;

import com.example.web_news.dto.request.CategoryCreationRequest;
import com.example.web_news.dto.request.CategoryUpdateRequest;
import com.example.web_news.entity.Category;
import com.example.web_news.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category/add")
    public String getFormAdd(Model model) {
        model.addAttribute("category",new Category());
        return "admin/category/formAddCategory";
    }
    @PostMapping("/category/create")
    public String addCategory(@ModelAttribute("category") @Valid CategoryCreationRequest request, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("category",request);
            return "admin/category/formAddCategory";
        }
        categoryService.add(request);
        return "redirect:/admin/category";
    }
    @GetMapping("/category/update/{id}")
    public String getFormUpdate(@PathVariable("id")String id, Model model){
        model.addAttribute("category",categoryService.findByID(id));
        return "admin/category/formUpdateCategory";
    }
    @PostMapping("/category/update/{id}")
    public String updateCategory(@PathVariable("id") String id,@ModelAttribute("category") @Valid CategoryUpdateRequest request, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("category",request);
            return "admin/category/formUpdateCategory";
        }
        categoryService.update(id,request);
        return "redirect:/admin/category";
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") String id){

        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }
}
