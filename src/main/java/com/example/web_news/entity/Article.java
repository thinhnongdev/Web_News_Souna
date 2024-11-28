package com.example.web_news.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Table(name = "article")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime create_date;
    LocalDateTime modified_date;
    String create_by;
    String modified_by;
    Boolean status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;
    public String getCreate_date() {
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return create_date.format(dateTimeFormatter);
    }
}
