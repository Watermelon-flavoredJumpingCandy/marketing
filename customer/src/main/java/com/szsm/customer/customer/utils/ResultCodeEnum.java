package com.szsm.customer.customer.utils;

public enum ResultCodeEnum {
    /*** 通用部分 100 - 599***/
    // 成功请求
    SUCCESS("000000", "successful");
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
