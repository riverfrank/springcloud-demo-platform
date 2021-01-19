package com.river.platfom.common.exception;

import com.river.platfom.common.ReturnCode;
import lombok.Data;

/**
 * @author river
 * @date 2020/12/18 11:14
 */
@Data
public class BizException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static void throwException(String message) {
        throw new BizException(ReturnCode.FAIL.getCode(),message);
    }
    public static void throwException(ReturnCode returnCode, String message) {
        throw new BizException(returnCode.getCode(),message);
    }
    public static void throwException(ReturnCode returnCode) {
        throw new BizException(returnCode.getCode(),returnCode.getMessage());
    }
    public static void throwException(int code, String message) {
        throw new BizException(code,message);
    }
}
