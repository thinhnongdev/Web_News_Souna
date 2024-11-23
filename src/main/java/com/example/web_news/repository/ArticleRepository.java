package com.example.web_news.repository;

import com.example.web_news.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,String> {
    @Query("SELECT n from Article n where n.status=true order by n.create_date DESC ")
    List<Article> getAll();
}
