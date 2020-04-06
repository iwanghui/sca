package com.wh.sca.security.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sca_user_role")
@Data
public class ScaUserRole {


    @TableField("user_id")
    private Long userId;


    @TableField("role_id")
    private Long roleId;

}
