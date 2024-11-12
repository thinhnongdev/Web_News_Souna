package com.example.web_news.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String code;
    String user_name;
    String full_name;
    LocalDateTime create_date;
    LocalDateTime modified_date;
    String create_by;
    String modified_by;
    Boolean status;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
