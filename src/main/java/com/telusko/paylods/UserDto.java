package com.telusko.paylods;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int id;

    @NotEmpty //NotNull + NotEmpty  (validation)
    @Size(min = 4,message = "your Name length should not be less than 4 cahr's")
    private String name;

    @NotEmpty
    @Email
    @Size(min = 6, max = 254,message = "email size must be in b/w  6 to 254 ")
    private String email;

    @NotEmpty(message = "Password Should Not Be Empty")
    @Size(min = 4, max = 30, message="password length must be in b/w 4 to 30 char's ")
    private String password;

    @NotEmpty
    private String about;
}
