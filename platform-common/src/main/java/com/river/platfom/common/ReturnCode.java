package com.river.platfom.common;

/**
 * @author river
 * @date 2020/12/18 10:01
 */
public enum ReturnCode {
    SUCCESS(0,"操作成功"),
    FAIL(1000,"操作失败"),
    REPEAT_COMMIT(1001,"重复提交"),

    /** -----------------------------通用错误码-------------------------------- */
    /** 10001, 输入错误！ */
    PARAM_ERROR(10001, "输入错误！"),
    /** 10002, 验证码错误！ */
    VERIFY_CODE_ERROR(10002, "验证码错误！"),
    /** 10003, 当天验证码发送次数超过上限！ */
    VERIFY_COUNT_ERROR(10003, "当天验证码发送次数超过上限！"),
    /** 10004, 验证短信发送过频！ */
    VERIFY_SEND_FREQUENCY(10004, "验证短信发送过频！"),
    /** 10004, 手机号错误！ */
    PHONE_ERROR(10005, "手机号错误！"),
    /** 10006, 配置错误！ */
    CONFIG_ERROR(10006, "配置错误！"),
    /** 10007, 短信网关错误！ */
    SMS_SERVER_ERROR(10007, "短信网关错误！"),
    /** 10008,特殊字符传入 */
    CHAR_FILTER(10008,"请勿填写特殊字符！"),
    /** 10009, 签名错误！ */
    SIGN_ERROR(10009, "签名错误！"),
    /** -----------------------------用户错误码------------------------------- */
    /** 11001, 异地登录提示！ */
    LOGIN_VARIOUS(11001, "异地登录提示！"),
    /** 11002, 用户已存在 */
    USER_EXIST(11002, "用户已存在"),
    /** 11003, 用户不存在 */
    USER_NO_EXIST(11003, "用户不存在"),
    /** 11004, 密码错误！ */
    PASSWORD_ERROR(11004, "密码错误！"),
    /** 11005, 登录已过期，请重新登录！ */
    LOGIN_OVERTIME(11005, "登录已过期，请重新登录！"),
    /** 11006, 用户未登陆 */
    NOT_LOGIN(11006, "用户未登陆"),
    /** 11007, 访问IP异常 */
    REQUEST_IP_ERROR(11007, "访问IP异常"),
    /** 11008, 用户id异常 */
    USER_ID_ERROR(11008, "用户ID异常！"),
    USERNAME_OR_PASSWORD_ERROR(11009, "用户名或者密码错误"),
    REQUEST_TIME_ERROR(11010, "请求时间过期"),


    /** ---------------------------------企业操作误码-------------------------------------- */
    EXIST_ENT(12001, "企业统一社会信用代码已经存在"),

    /** ---------------------------------程序异常错误码-------------------------------------- */
    /** 404, 请求不存在 */
    NO_PAGE_ERROR(404, "请求不存在"),
    /** 90001, 程序异常！ */
    PROGRAM_ERROR(90001, "程序异常！"),
    /** 90002, 不支持的数据格式！！ */
    MEDIA_TYPE_ERROR(90002, "不支持的数据格式！"),
    /** 90003, 不支持的参数类型！ */
    DATA_TYPE_ERROR(90003, "不支持的参数类型！"),
    /** 90004, 不支持的请求类型！ */
    REQUEST_TYPE_ERROR(90004, "不支持的请求类型！"),
    /** 90005, 没有传参 */
    PARAM_NULL_ERROR(90005, "没有传参"),
    /** 90006, json解析异常！ */
    JSON_ERROR(90006, "json解析异常！"),
    /** 90007, sql语句异常！ */
    SQL_ERROR(90007, "sql语句异常！"),
    /** 90008, 文件（上传）不存在！ */
    FILE_ERROR(90008, "文件不存在！"),
    /** 90009, 数据访问异常！ */
    DATA_ACCESS_ERROR(90009, "数据访问异常！"),
    DATA_VALID_ERROR(90010, "数据效验失败！")
    ;



    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
