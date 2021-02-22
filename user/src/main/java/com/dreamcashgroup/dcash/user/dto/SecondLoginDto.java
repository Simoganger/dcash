package com.dreamcashgroup.dcash.user.dto;

import javax.validation.constraints.NotBlank;

public class SecondLoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
