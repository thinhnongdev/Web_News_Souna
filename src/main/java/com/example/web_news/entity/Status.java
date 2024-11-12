package com.example.web_news.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "status")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String code;
    String emotion;
    LocalDateTime create_date;
    LocalDateTime modified_date;
    String create_by;
    String modified_by;
    Boolean status;
    @ManyToOne
    @Column(name = "user_id")
    User user;
    @ManyToOne
    @Column(name = "user_id")
    News news;
}
