package com.gloryh.resultvo.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gloryh.resultvo.common.annotation.NotControllerResponseAdvice;
import com.gloryh.resultvo.common.code.ResultCode;
import com.gloryh.resultvo.common.code.ResultVo;
import com.gloryh.resultvo.common.exception.APIException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 用来将所有 com.gloryh.resultvo 下的 controller 进行统一处理
 *
 * @author GloryH
 */
@RestControllerAdvice(basePackages = {"com.gloryh.resultvo"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(
      MethodParameter parameter, Class<? extends HttpMessageConverter<?>> clazz) {
    // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
    return !(parameter.getParameterType().isAssignableFrom(ResultVo.class)
        || parameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
  }

  @Override
  public Object beforeBodyWrite(
      Object data,
      MethodParameter parameter,
      MediaType mediaType,
      Class<? extends HttpMessageConverter<?>> clazz,
      ServerHttpRequest request,
      ServerHttpResponse response) {
    if (parameter.getGenericParameterType().equals(String.class)) {
      ObjectMapper mapper = new ObjectMapper();
      // 将数据封装为ResultVo后转为json返回
      try {
        return mapper.writeValueAsString(new ResultVo(data));
      } catch (JsonProcessingException e) {
        // 转换失败报错
        throw new APIException(ResultCode.RESPONSE_PACK_ERROR, e.getMessage());
      }
    }
    // 否则直接包装成ResultVo返回
    return new ResultVo(data);
  }
}
