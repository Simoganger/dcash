package com.dreamcashgroup.dcash.model.enums;

public enum EnumMobileProvider {
    ORANGE_MONEY("OM"),
    MTN_MOBILE_MONEY("MOMO"),
    YUP("YUP");

    private String value;

    EnumMobileProvider(String value){
        this.value = value;
    }

    public String getStatus(){
        return this.value;
    }
}
