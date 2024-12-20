package com.example.web_news.dto.response;

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
public class ArticleResponse {
    String code;
    String title;
    String short_description;
    String thumbnail;
    String description;
    String content;
    String create_date;
    String modified_date;
    String create_by;
    String modified_by;
    Boolean status;
}
