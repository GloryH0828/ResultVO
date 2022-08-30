package com.gloryh.resultvo.common.exception;

import com.gloryh.resultvo.common.code.AppCode;
import com.gloryh.resultvo.common.code.StatusCode;
import lombok.Getter;

/**
 * API 异常处理
 *
 * @author GloryH
 */
@Getter
public class APIException extends RuntimeException {
  private int code;
  private String msg;

  /** 默认异常 */
  public APIException(String message) {
    super(message);
    this.code = AppCode.APP_ERROR.getCode();
    this.msg = AppCode.APP_ERROR.getMsg();
  }

  /** 手动处理异常 */
  public APIException(StatusCode code, String message) {
    super(message);
    this.code = code.getCode();
    this.msg = code.getMsg();
  }
}
