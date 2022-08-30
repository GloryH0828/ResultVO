package com.gloryh.resultvo.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author GloryH
 */
@Data
public class UserVo {
  @NotNull(message = "用户名不得为空")
  private String username;

  @Min(value = 1,message = "部门ID应大于0")
  private Integer departmentId;
}
