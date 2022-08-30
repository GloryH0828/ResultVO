package com.gloryh.resultvo.controller;

import com.gloryh.resultvo.common.annotation.NotControllerResponseAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GloryH
 */
@RestController
public class HealthController {

  @GetMapping("/health")
  @NotControllerResponseAdvice
  public String health() {
    return "success";
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }
}
