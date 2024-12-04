package com.example.web_news.repository;

import com.example.web_news.entity.Category;
import com.example.web_news.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u from User u where u.status=true order by u.create_date DESC ")
    List<User> findAll();
    @Query("SELECT u from User u where u.user_name=:user_name")
    Optional<User> findByUserName(@Param("user_name") String username);
}
