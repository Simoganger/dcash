package com.dreamcashgroup.dcash.common.exception;

public class DCashCommonException extends Exception{
    EnumErrorCode errorCode;
    Object data;

    public DCashCommonException(EnumErrorCode errorCode, String message, Object data, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.data = data;
    }
    public DCashCommonException(EnumErrorCode errorCode, Object data, Throwable cause) {
        super( cause);
        this.errorCode = errorCode;
        this.data = data;
    }
    public DCashCommonException(EnumErrorCode errorCode, Object data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    public DCashCommonException(EnumErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public EnumErrorCode getErrorCode() {
        return errorCode;
    }
}
