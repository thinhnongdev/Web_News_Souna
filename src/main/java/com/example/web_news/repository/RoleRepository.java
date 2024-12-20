package com.example.web_news.repository;

import com.example.web_news.entity.Role;
import com.example.web_news.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public interface RoleRepository extends JpaRepository<Role,String> {
    @Query("SELECT r from Role r where r.status=true order by r.create_date DESC ")
    List<Role> findAll();
    @Query("SELECT r from Role r where r.name=:name")
    Role findByName(@Param("name") String name);
}
