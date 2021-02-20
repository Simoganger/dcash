package com.dreamcashgroup.dcash.model.enums;

public enum EnumTransactionType {
    DEPOSIT("DEPOSIT"),
    WITHDRAWAL("WITHDRAWAL"),
    TRANSFER("TRANSFER");

    private String value;

    EnumTransactionType(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
