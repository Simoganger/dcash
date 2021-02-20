package com.dreamcashgroup.dcash.model.entity;

import com.dreamcashgroup.dcash.model.enums.EnumHistoryType;

import javax.persistence.Entity;

@Entity
public class LogoutHistory extends History {

    private String username;
    private String password;

    @Override
    protected EnumHistoryType getType() {
        return EnumHistoryType.LOGOUT;
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
