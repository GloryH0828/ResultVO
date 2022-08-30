package com.gloryh.resultvo.common.code;

import lombok.Getter;

/**
 * 程序异常码
 *
 * @author GloryH
 */
@Getter
public enum AppCode implements StatusCode {
  /** 异常状态码枚举 */
  APP_ERROR(2000, "业务异常"),
  PARAM_ERROR(2001, "参数异常");

  private int code;
  private String msg;

  AppCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
