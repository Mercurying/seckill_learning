package com.mercury.error;

public interface CommonError {
    int getErrorCode();

    String getErrorMsg();

    CommonError setErrorMsg(String errorMsg);
}
