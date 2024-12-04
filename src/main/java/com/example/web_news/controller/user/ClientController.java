package com.example.web_news.controller.user;

import com.example.web_news.dto.request.LoginUserRequest;
import com.example.web_news.dto.request.SignupUserRequest;
import com.example.web_news.entity.Article;
import com.example.web_news.entity.User;
import com.example.web_news.service.ArticleService;
import com.example.web_news.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

@Controller
public class ClientController {
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    @GetMapping(value = {"Souna", "/", "", "home"})
    public String handleIndex(HttpSession session, Model model) {
        if (session.getAttribute("UserName") != null) {
            model.addAttribute("status",true);
        }else {
            model.addAttribute("status",false);
        }
        model.addAttribute("articlesForUser", articleService.getAllArticleForUser());
        return "user/index";
    }

    @GetMapping("/article/detail/{id}")
    public String GetArticleById(@PathVariable("id") String id, Model model) {
        model.addAttribute("article", articleService.findByID(id));
        return "user/detailArticle";
    }

    @GetMapping("/search")
    public String SearchArticle(@RequestParam("search") String title, Model model) {
        model.addAttribute("search_article", articleService.findByTitle(title));
        return "user/searchArticle";
    }

    @GetMapping("/createnewpost")
    public String GetFormCreateNewArticle(Model model) {
        model.addAttribute("newArticle", new Article());
        return "user/formAddArticle";
    }

    @PostMapping("/createnewpost")
    public String CreateNewArticle(@ModelAttribute("newArticle") Article article, Model model) {
        model.addAttribute("newArticle", article);
        return "user/index";
    }

    @GetMapping("/login")
    public String GetFormLogin(Model model) {
        model.addAttribute("user", new LoginUserRequest());
        return "user/authentication-login";
    }

    @PostMapping("/login")
    public String handleLogin(HttpSession session, @ModelAttribute("user") LoginUserRequest loginUserRequest, Model model) {
        if (userService.checkLogin(loginUserRequest.getUser_name(), loginUserRequest.getPass_word()) == true) {
            session.setAttribute("UserName", loginUserRequest.getUser_name());
            return "redirect:/home";
        }
        model.addAttribute("user", loginUserRequest);
        model.addAttribute("ERROR", "Email or PassWord not exist");
        return "user/authentication-login";
    }

    @GetMapping("/logout")
    public String HandleLogout(HttpSession session, Model model) {
        model.addAttribute("user", new LoginUserRequest());
        session.removeAttribute("UserName");
        return "redirect:/login";
    }
    @GetMapping("/register")
    public String GetFormRegister( Model model) {
        model.addAttribute("userRegister", new SignupUserRequest());
        return "user/authentication-register";
    }
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("userRegister") @Valid SignupUserRequest request, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("userRegister", request);
            return "user/authentication-register";
        }
        userService.registerUser(request);
        return "redirect:/login";
    }
}
