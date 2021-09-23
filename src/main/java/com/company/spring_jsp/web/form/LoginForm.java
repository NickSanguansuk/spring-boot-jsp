package com.company.spring_jsp.web.form;

import javax.validation.constraints.NotNull;

public class LoginForm {

    @NotNull
    private String username;
    @NotNull
    private String password;

    public LoginForm() {
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
}
