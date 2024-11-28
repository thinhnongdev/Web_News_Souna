package com.example.web_news.dto.request;

import com.example.web_news.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleUpdateRequest {
    String id;
    String code;
    @NotEmpty
    @Size(min = 8,message = "Title must be at least 8 characters")
    String title;
    String short_description;
    String thumbnail;
    String description;
    @NotEmpty
    @Size(min = 20,message = "Content must be at least 20 characters")
    String content;
    LocalDateTime modified_date;
    String modified_by;
    Boolean status;
    Category category;
}
