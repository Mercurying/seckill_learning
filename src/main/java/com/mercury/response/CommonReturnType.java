package com.mercury.response;

/*定义通用的返回结果形式*/
public class CommonReturnType {

    /*返回给前端的状态 若status="success" 则返回 data数据  若 status="fail" 只返回标志符*/
    private String status;
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
