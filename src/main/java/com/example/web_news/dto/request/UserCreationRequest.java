package com.example.web_news.dto.request;

import com.example.web_news.entity.Role;
import jakarta.persistence.*;
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
public class UserCreationRequest {



    @NotNull
    @Size(min = 2,message = "User name must be at least 2 characters")
    @Email(message = "Email is not in correct format")
    String user_name;
    @Size(min = 6,message = "Password must be at least 6 characters")
    String pass_word;
    @NotNull
    @Size(min = 8,message = "Full name must be at least 8 characters")
    String full_name;
    LocalDateTime create_date;
    String create_by;
    Boolean status;
    Boolean active;
    Role role;
}
