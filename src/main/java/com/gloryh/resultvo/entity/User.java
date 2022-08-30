package com.gloryh.resultvo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 *
 * @author GloryH
 */
@Data
@TableName("user")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "user_id", type = IdType.AUTO)
  private Integer id;

  @TableField(value = "department_id")
  private Integer departmentId;

  @TableField private String username;
  @TableField private String password;
  @TableField private Integer age;
  @TableField private Date birthday;
}
