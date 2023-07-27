package com.jiemei.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginModel {
    @NotNull(message = "Username is required.")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15.")
    private String username;

    @NotNull
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15.")
    private String password;
}
