package com.gloryh.resultvo.common.code;

import lombok.Data;

/**
 * 统一返回处理
 *
 * @author 黄光辉
 */
@Data
public class ResultVo {
    private int code;
    private String msg;
    private Object data;

    /**
     * 手动传入返回vo，需要传入返回数据
     */
    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 手动传入返回vo，无需传入返回数据
     */
    public ResultVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    /**
     * 默认返回成功结果，只需要传入返回数据
     */
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 默认返回成功结果，无需传入返回数据
     */
    public ResultVo() {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = null;
    }

    /**
     * 根据状态码返回，无需数据对象
     */
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

    /**
     * 根据状态码返回，需数据对象
     */
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }
}
