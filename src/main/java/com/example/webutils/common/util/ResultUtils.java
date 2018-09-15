package com.example.webutils.common.util;

import com.example.webutils.common.bean.BaseResult;
import com.example.webutils.common.enums.ResultCodeEnum;
import com.example.webutils.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类的实现描述：ResultUtils
 *
 * @author sunyajun 2018/9/15 23:05
 */
public class ResultUtils {

    public static <T> BaseResult<T> newResult(ResultCodeEnum code, String msg, T t) {
        return newResult(code.getCode(), msg, t);
    }

    public static <T> BaseResult<T> newResult(String code, String msg, T t) {
        BaseResult<T> result = new BaseResult<T>();
        result.setCode(code);
        result.setMessage(msg);
        result.setResult(t);
        return result;
    }

    public static <T> BaseResult<T> newDefaultResult(T t) {
        BaseResult<T> result = new BaseResult<T>();
        result.setCodeSuccess();
        result.setMessage(ResultCodeEnum.RESULT_SUCCESS.getValue());
        result.setResult(t);
        return result;
    }

    /**
     * 没有返回对象的util
     *
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> newNoObjectResult() {
        BaseResult<T> result = new BaseResult<T>();
        result.setCodeSuccess();
        result.setMessage(ResultCodeEnum.RESULT_SUCCESS.getValue());
        return result;
    }

    @ExceptionHandler
    @ResponseBody
    public static <T> BaseResult<T> newExceptionResult(Exception e) {
        BaseResult<T> result = new BaseResult<T>();
        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            result.setCode(
                    ex.getErrorCode() == null ? ResultCodeEnum.RESULT_ERROR_BUSINESS.getCode() : ex.getErrorCode());
            result.setMessage(ex.getErrorMsg());
        } else {
            result.setCode(ResultCodeEnum.RESULT_ERROR_SYSTEM_EXCEPTION.getCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }

    public static <T> T getResultValue(BaseResult<T> result) {
        if (result.success()) {
            return result.getResult();
        }
        throw new BusinessException(result.getCode(), result.getMessage());
    }
}
