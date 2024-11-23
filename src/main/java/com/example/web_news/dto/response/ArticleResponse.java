package com.example.web_news.dto.response;

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
    LocalDateTime create_date;
    LocalDateTime modified_date;
    String create_by;
    String modified_by;
    Boolean status;
}
