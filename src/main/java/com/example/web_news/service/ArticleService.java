package com.example.web_news.service;

import com.example.web_news.dto.request.ArticleCreationRequest;
import com.example.web_news.dto.request.ArticleUpdateRequest;
import com.example.web_news.entity.Article;
import com.example.web_news.entity.Category;
import com.example.web_news.repository.ArticleRepository;
import com.example.web_news.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArticleService {
    ArticleRepository articleRepository;
    CategoryRepository categoryRepository;

    public List<Article> getAllArticle() {
        return articleRepository.getAll();
    }

    public Article findByID(String id) {
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found Article"));
    }

    public Article add(ArticleCreationRequest request, String category_id) {
        Article article=new Article();
        Random random=new Random();
        String code="NEWS"+random.nextInt(100000);
        Category category=categoryRepository.findById(category_id).orElseThrow(()->new RuntimeException("Not Found Category"));
        article.setCategory(category);
        article.setCode(code);
        article.setTitle(request.getTitle());
        article.setShort_description(request.getShort_description());
        article.setThumbnail(request.getThumbnail());
        article.setContent(request.getContent());
        article.setCreate_date(LocalDateTime.now());
        article.setStatus(true);
        return articleRepository.save(article);
    }

    public Article update(String id, ArticleUpdateRequest article, String category_id) {
        Article article1 = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        article1.setTitle(article.getTitle());
        Category category=categoryRepository.findById(category_id).orElseThrow(()->new RuntimeException("Not Found Category"));
        article1.setCategory(category);
        article1.setThumbnail(article.getThumbnail());
        article1.setShort_description(article.getShort_description());
        article1.setContent((article.getContent()));
        article1.setModified_date(LocalDateTime.now());
        return articleRepository.save(article1);
    }

    public void deleteById(String id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        article.setStatus(false);
        articleRepository.save(article);
    }
}
