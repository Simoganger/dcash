package com.dreamcashgroup.dcash.model.enums;

public enum EnumTokenType {
    LOGIN_TOKEN("LOGIN_TOKEN"),
    PASSWORD_RESET_TOKEN("PASSWORD_RESET_TOKEN");

    private String value;

    EnumTokenType(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
