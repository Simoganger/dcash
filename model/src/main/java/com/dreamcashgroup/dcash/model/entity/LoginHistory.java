package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumHistoryType;

import javax.persistence.Entity;

@Entity
public class LoginHistory extends History{
    private String username;
    private String password;
    private boolean status;

    @Override
    protected EnumHistoryType getType() {
        return EnumHistoryType.LOGIN;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
