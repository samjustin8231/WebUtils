package com.example.webutils.common.enums;

import lombok.Getter;

/**
 * 类的实现描述：ResultCodeEnum
 *
 * @author sunyajun 2018/9/15 23:06
 */

public enum ResultCodeEnum {

    RESULT_SUCCESS("0", "成功"),
    RESULT_SUCCESS_THIRD_API("00000", "第三方调用成功"),

    /* ERROE CODE COMMON */
    RESULT_ERROR_PARAMS("20001", "请求参数不正确"),
    RESULT_ERROR_NOT_LOGGED("20002", "用户未登录,请先登录"),
    RESULT_ERROR_NO_ACCESS("20003", "没有权限访问该资源"),
    RESULT_ERROR_RES_MISSED("20004", "资源不存在"),
    RESULT_ERROR_RES_OP_NONSUPPORTED("20005", "资源的当前状态不支持该操作"),
    RESULT_ERROR_LACK_CONF("20006", "缺少必要的配置项"),
    RESULT_ERROR_BUSINESS("20007", "业务处理失败"),
    RESULT_ERROR_THIRD_API("20008", "调用第三方接口失败"),
    RESULT_ERROR_RES_DELETED("20009", "资源已删除"),
    RESULT_ERROR_UPDATE("20010", "更新操作失败"),
    RESULT_ERROR_PARAMS_MISSED("20011", "参数缺失"),
    RESULT_ERROR_TRANCACTION("20012", "事务异常"),
    RESULT_ERROR_EXPORT_FILE("20013", "导出文件异常"),
    RESULT_ERROR_VALIDATE_SIGN("20014", "验签失败"),

    RESULT_ERROR_SYSTEM_MAINTAINING("40001", "系统维护中"),
    RESULT_ERROR_SYSTEM_EXCEPTION("40003", "系统异常"),
    RESULT_ERROR_SYSTEM_BUSY("40002", "系统繁忙"),

    RESULT_ERROR_USER_NOTEXISTS("30001", "用户不存在"),
    RESULT_ERROR_PASSWORD("30002", "用户密码错误"),
    RESULT_ERROR_OLD_PASSWORD_EQUAL_NEW_PASSWORD("30003", "新密码不能和原密码相同"),
    RESULT_ERROR_NEW_PASSWORD_EQUAL_RE_NEW_PASSWORD("30004", "确认新密码与新密码不一致"),

    RESULT_ERROR_RECORDS_COUNT("20015", "记录数量异常"),
    RESULT_ERROR_RECORDS_DUPLICATION("20016", "记录重复"),

    RESULT_ERROR_SEND_EMAIL("20019", "邮件发送失败");

    @Getter
    private String code;

    @Getter
    private String value;

    /**
     * @param code
     * @param value
     */
    ResultCodeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

}
