package com.dreamcashgroup.dcash.model.enums;

public enum EnumHistoryType {
    ACCOUNT_UPDATE("ACCOUNT_UPDATE"),
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    USER_UPDATE("USER_UPDATE");

    private String value;

    EnumHistoryType(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
