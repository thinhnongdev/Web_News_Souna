package com.example.web_news.service;

import com.example.web_news.dto.request.ArticleCreationRequest;
import com.example.web_news.dto.request.ArticleUpdateRequest;
import com.example.web_news.dto.request.CategoryCreationRequest;
import com.example.web_news.dto.request.CategoryUpdateRequest;
import com.example.web_news.entity.Article;
import com.example.web_news.entity.Category;
import com.example.web_news.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {
    CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    public Category add(CategoryCreationRequest request) {
        Category category=new Category();
        Random random=new Random();
        String code="CAT"+random.nextInt(100000);
        category.setCode(code);
        category.setDescription(request.getDescription());
        category.setName(request.getName());
        category.setCreate_date(LocalDateTime.now());
        category.setStatus(true);
        return categoryRepository.save(category);
    }

    public Category update(String id, CategoryUpdateRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setModified_date(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public void deleteById(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        category.setStatus(false);
        categoryRepository.save(category);
    }
    public Category findByID(String id){
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found Category"));
    }
}
