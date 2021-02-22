package com.dreamcashgroup.dcash.common.exception;

public class DCashDBItemAlreadyExistException extends DCashCommonException {
    String entity;
    String field;
    String value;

    public DCashDBItemAlreadyExistException(EnumErrorCode errorCode, String message, Throwable cause, String entity, String field, String value) {
        super(errorCode, message, cause);
        this.entity=entity;
        this.field=field;
        this.value=value;

    }

    public DCashDBItemAlreadyExistException(EnumErrorCode errorCode, Throwable cause, String entity, String field, String value) {
        super(errorCode,  cause);
        this.entity=entity;
        this.field=field;
        this.value=value;
    }

    public DCashDBItemAlreadyExistException(EnumErrorCode errorCode, String entity, String field, String value) {
        super(errorCode);
        this.entity=entity;
        this.field=field;
        this.value=value;
    }
}
