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
public class ScaPermission extends Model<ScaPermission> {

    @TableId(value="id", type= IdType.AUTO)
    private Long id;

    private Long pid;

    @TableField("permission_name")
    private String permissionName;

    @TableField("permission_label")
    private String permissionLabel;

    @TableField("permission_code")
    private String permission_code;

    @TableField("permission_desc")
    private String permissionDesc;

    @TableField("permission_type")
    private String permissionType;


    @TableField("url")
    private String url;

    @TableField("sort")
    private Integer sort;


    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

}
