package com.example.webutils.common.bean;

import java.io.Serializable;

/**
 * 类的实现描述：BaseResult
 *
 * @author sunyajun 2018/9/15 23:02
 */

public class BaseResult<T> implements Serializable {

    public static final String SUCCESS_CODE = "0";
    private static final long serialVersionUID = 5758020086424746744L;
    private String code;
    private String message;
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCodeSuccess() {
        this.code = SUCCESS_CODE;
    }

    public boolean success() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean failed() {
        return !success();
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setSuccess(T result) {
        setCodeSuccess();
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseResult [code=" + code + ", message=" + message + ", result=" + result + "]";
    }

}