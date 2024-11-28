package com.example.web_news.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class CategoryCreationRequest {
    @NotNull
    @Size(min = 2,message = "Name must be at least 2 characters")
    String name;
    @NotNull
    @Size(min = 8,message = "Name must be at least 8 characters")
    String description;
    LocalDateTime create_date;
    String create_by;
}
