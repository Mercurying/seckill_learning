package com.mercury.review.webservice.common;

public enum ServerResponse {
    INVALID_PARAMETER(100, "参数错误");
    private int code;
    private String msg;

    ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
