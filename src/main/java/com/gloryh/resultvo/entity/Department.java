package com.gloryh.resultvo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 部门
 *
 * @author GloryH
 */
@Data
@TableName("department")
public class Department {
  @TableId(value = "department_id", type = IdType.AUTO)
  private Integer id;

  private String name;
  private String code;
}
