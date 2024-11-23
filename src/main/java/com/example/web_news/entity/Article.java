package com.example.web_news.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "news")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String code;
    String title;
    String short_description;
    String thumbnail;
    String content;
    LocalDateTime create_date;
    LocalDateTime modified_date;
    String create_by;
    String modified_by;
    Boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
}
