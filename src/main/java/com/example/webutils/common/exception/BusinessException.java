package com.example.webutils.common.exception;

import com.example.webutils.common.constant.ErrorCode;

/**
 * 类的实现描述：BusinessException
 *
 * @author sunyajun 2018/9/15 23:07
 */

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1266586526831391211L;
    private String errorCode;
    private String errorMsg;

    public BusinessException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(ErrorCode code, Object... args) {
        this.errorCode = code.getCode();
        this.errorMsg = code.getErrorMsg(args);
    }

    public BusinessException() {
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorMsg = message;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorMsg = message;
    }

    public BusinessException(String message) {
        super(message);
        this.errorMsg = message;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", this.errorCode, this.errorMsg);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
