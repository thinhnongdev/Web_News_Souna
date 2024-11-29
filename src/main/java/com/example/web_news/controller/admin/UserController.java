package com.example.web_news.controller.admin;

import com.example.web_news.dto.request.UserCreationRequest;
import com.example.web_news.dto.request.UserUpdateRequest;
import com.example.web_news.entity.Category;
import com.example.web_news.entity.Role;
import com.example.web_news.entity.User;
import com.example.web_news.service.RoleService;
import com.example.web_news.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @GetMapping("/user/add")
    public String handleRegister(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/formAddUser";
    }

    @ModelAttribute("role_list")
    public List<Role> handleRole() {
        return roleService.findAll();
    }
    @PostMapping("/user/add")
    public String handleCreateUser(@ModelAttribute("user") @Valid UserCreationRequest userCreationRequest, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("user",userCreationRequest);
            return "admin/user/formAddUser";
        }
        userService.add(userCreationRequest);
        return "redirect:/admin/user";
    }
    @GetMapping("/user/update/{id}")
    public String GetFormUpdate( @PathVariable("id")String id, Model model) {
        model.addAttribute("user",userService.findByID(id));
        return "admin/user/formUpdateUser";
    }
    @PostMapping("/user/update/{id}")
    public String handleUpdateUser(@PathVariable("id")String id,@ModelAttribute("user") @Valid UserUpdateRequest userUpdateRequest,  BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("user",userUpdateRequest);
            return "admin/user/formUpdateUser";
        }
        userService.update(id,userUpdateRequest);
        return "redirect:/admin/user";
    }
    @GetMapping("/user/delete/{id}")
    public String handleDelete( @PathVariable("id")String id) {
        userService.deleteById(id);
        return "redirect:/admin/user";
    }
}
