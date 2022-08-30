package com.gloryh.resultvo.common.advice;

import com.gloryh.resultvo.common.code.ResultCode;
import com.gloryh.resultvo.common.code.ResultVo;
import com.gloryh.resultvo.common.exception.APIException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author GloryH
 */
@RestControllerAdvice
public class ControllerExceptionAdvice {

  @ExceptionHandler({BindException.class})
  public ResultVo methodArgumentNotValidExceptionHandler(BindException e) {
    // 从异常对象中获取ObjectError对象
    ObjectError error = e.getBindingResult().getGlobalError();
    assert error != null;
    return new ResultVo(ResultCode.VALIDATE_ERROR, error.getDefaultMessage());
  }

  /**
   * 进行统一异常的拦截
   *
   * @param e 抛出的APIException
   * @return 错误被封装后的 ResultVo
   */
  @ExceptionHandler(APIException.class)
  public ResultVo APIExceptionHandler(APIException e) {
    return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
  }
}
