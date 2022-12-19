package com.trollmarket.dto.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterAdminDTO {
    @NotBlank(message = "Username is required")
    @NotNull(message = "Username is required")
    private String username;

    @NotBlank(message = "password is required")
    @NotNull(message = "Username is required")
    private String password;

    @NotBlank(message = "password confirmation is required")
    @NotNull(message = "Username is required")
    private String confirmPassword;

    @NotBlank(message = "role is required")
    @NotNull(message = "Username is required")
    private String role;

    public RegisterAdminDTO(){}

    public RegisterAdminDTO(String username, String password, String confirmPassword, String role) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
