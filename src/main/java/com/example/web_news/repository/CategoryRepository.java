package com.example.web_news.repository;

import com.example.web_news.entity.Article;
import com.example.web_news.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT c from Category c where c.status=true order by c.create_date DESC ")
    List<Category> findAll();
}
