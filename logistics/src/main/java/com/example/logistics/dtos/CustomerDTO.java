package com.example.logistics.dtos;

import com.example.logistics.enums.LoginType;

import com.example.logistics.validation.ValidLoginType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {


    @ValidLoginType
    private LoginType loginType;

    @Email(message = "Invalid Email")
    private String email;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
