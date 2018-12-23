package com.mercury.error;

public enum EnumBusinessError implements CommonError {
    /*定义通用错误类型 10001*/
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    UNKNOWN_ERROR(10002, "未知错误"),
    /*用户模块错误类型以20000开通进行标志*/
    USER_NOT_EXIST(20001, "用户不存在");

    private int errorCode;
    private String errorMsg;

    private EnumBusinessError(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}
