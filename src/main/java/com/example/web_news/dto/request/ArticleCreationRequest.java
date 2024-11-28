package com.example.web_news.dto.request;

import com.example.web_news.entity.Category;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleCreationRequest {
    @NotNull
    @Size(min = 8,message = "Title must be at least 8 characters")
    String title;
    String short_description;
    String thumbnail;
    String description;
    @NotNull
    @Size(min = 20,message = "Title must be at least 8 characters")
    String content;
    LocalDateTime create_date;
    String create_by;
    Boolean status;
    Category category;
}
