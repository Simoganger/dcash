package com.dreamcashgroup.dcash.model.enums;

public enum EnumAccountType {
    CHECKING("CHECKING"),
    SAVING("SAVING");

    private String value;

    EnumAccountType(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
