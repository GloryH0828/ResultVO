package com.gloryh.resultvo.common.code;

import lombok.Getter;

/**
 * @author GloryH
 */
@Getter
public enum ResultCode implements StatusCode {
    //美剧所有状态码
    SUCCESS(1000, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "请求返回包装失败");
    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;


    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
