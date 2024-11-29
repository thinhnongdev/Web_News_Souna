package com.example.web_news.service;

import com.example.web_news.dto.request.CategoryCreationRequest;
import com.example.web_news.dto.request.CategoryUpdateRequest;
import com.example.web_news.dto.request.UserCreationRequest;
import com.example.web_news.dto.request.UserUpdateRequest;
import com.example.web_news.entity.Category;
import com.example.web_news.entity.Role;
import com.example.web_news.entity.User;
import com.example.web_news.repository.CategoryRepository;
import com.example.web_news.repository.RoleRepository;
import com.example.web_news.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
RoleRepository roleRepository;
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User add(UserCreationRequest request) {
        User user = new User();
        Role role=roleRepository.findById(request.getRole().getId()).orElseThrow(()->new RuntimeException("Not Found Role"));
        user.setRole(role);
        user.setUser_name(request.getUser_name());
        user.setFull_name(request.getFull_name());
        user.setPass_word(request.getPass_word());
        user.setActive(request.getActive());
        user.setCreate_date(LocalDateTime.now());
        user.setStatus(true);
        return userRepository.save(user);
    }

    public User update(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found User"));
        Role role=roleRepository.findById(request.getRole().getId()).orElseThrow(()->new RuntimeException("Not Found Role"));
        user.setRole(role);
        user.setFull_name(request.getFull_name());
        user.setPass_word(request.getPass_word());
        user.setActive(request.getActive());
        user.setModified_date(LocalDateTime.now());
        user.setStatus(true);
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        user.setStatus(false);
        userRepository.save(user);
    }

    public User findByID(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found User"));
    }
}
