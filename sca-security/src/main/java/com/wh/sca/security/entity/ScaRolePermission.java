package com.wh.sca.security.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sca_role_permission")
@Data
public class ScaRolePermission {


    @TableField("role_id")
    private Long roleId;


    @TableField("permission_id")
    private Long permissionId;



}
