package com.example.web_news.repository;

import com.example.web_news.entity.Article;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,String> {
    @Query("SELECT n from Article n where n.status=true order by n.create_date DESC ")
    List<Article> getAllforAdmin();
    @Query("SELECT n from Article n where n.status=true order by n.create_date DESC ")
    List<Article> getAllforUser();
    @Query("SELECT n from Article n where n.status=true and n.title like :title order by n.create_date DESC ")
    List<Article> searchByTitleForUser(@Param("title") String title);
}
