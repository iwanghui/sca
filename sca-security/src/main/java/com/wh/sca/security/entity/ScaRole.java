package com.wh.sca.security.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@TableName("t_sca_role")
@Data
public class ScaRole extends Model<ScaRole> {

    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    @TableField("role_name")
    private String roleName;

    @TableField("role_code")
    private String roleCode;


    @TableField("role_desc")
    private String roleDesc;


    @TableField("role_type")
    private String roleType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;


}
