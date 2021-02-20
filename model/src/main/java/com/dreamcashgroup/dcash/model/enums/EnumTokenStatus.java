package com.dreamcashgroup.dcash.model.enums;

public enum EnumTokenStatus {

    PENDING("PENDING"),
    VERIFIED("VERIFIED"),
    EXPIRED("EXPIRED");

    private String value;

    EnumTokenStatus(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
