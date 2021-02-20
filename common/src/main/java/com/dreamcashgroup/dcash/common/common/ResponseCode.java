package com.dreamcashgroup.dcash.common.common;

public enum ResponseCode {
    OK (200),
    CREATED (201),
    ABORTED (300),
    BAD_REQUEST (400),
    NOT_FOUND (404),
    INTERNAL_ERROR (500),
    EMAIL_EXIST (1000);

    private int value;

    ResponseCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
