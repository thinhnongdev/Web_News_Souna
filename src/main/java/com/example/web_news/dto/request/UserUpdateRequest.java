package com.example.web_news.dto.request;

import com.example.web_news.entity.Role;
import jakarta.validation.constraints.Email;
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
public class UserUpdateRequest {
    String id;
    String user_name;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters")
    String pass_word;
    @NotNull
    @Size(min = 8, message = "Name must be at least 8 characters")
    String full_name;
    LocalDateTime modified_date;
    String modified_by;
    Boolean status;
    Boolean active;
    Role role;
}
