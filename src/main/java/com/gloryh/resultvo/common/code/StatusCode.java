package com.gloryh.resultvo.common.code;

/**
 * 状态码基础接口
 *
 * @author GloryH
 */
public interface StatusCode {
    /**
     * 获取状态码
     *
     * @return 状态码的值
     */
    public int getCode();

    /**
     * 获取返回信息
     *
     * @return 信息
     */
    public String getMsg();
}
