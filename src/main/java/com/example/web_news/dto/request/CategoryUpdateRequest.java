package com.example.web_news.dto.request;

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
public class CategoryUpdateRequest {
    String id;
    @NotNull
    @Size(min = 2,message = "Name must be at least 2 characters")
    String name;
    @NotNull
    @Size(min = 8,message = "Name must be at least 8 characters")
    String description;
    LocalDateTime modified_date;
    String modified_by;
    Boolean status;
}
