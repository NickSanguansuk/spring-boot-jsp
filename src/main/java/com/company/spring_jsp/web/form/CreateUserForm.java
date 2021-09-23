package com.company.spring_jsp.web.form;

import javax.validation.constraints.*;

public class CreateUserForm {
    // Data
    //@NotNull
    @NotEmpty(message = "Email cannot be empty.")
    //@Email(message = "@Email is invalid.")
    @Pattern(regexp = "^.*@.*$", message = "Email format is invalid.")
    private String email;

    //@NotNull
    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters.")
    @Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain at least on digit, 0 through 9.")
    @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one lowercase letter.")
    @Pattern(regexp = "(?=.*[!@#\\$%\\^&\\*]).+", message = "Password must contain at least one special character, ! @ # $ % ^ & *.")
    private String password;

    //@NotNull
    @NotEmpty(message = "Confirm Password cannot be empty.")
    private String confirmPassword;

    //@NotNull
    @NotEmpty(message = "Full name is required.")
    private String fullName;

    private String phone;

    // Constructors
    public CreateUserForm() {
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CreateUserForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
