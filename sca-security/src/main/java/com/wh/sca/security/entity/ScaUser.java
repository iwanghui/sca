package com.wh.sca.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@TableName("t_sca_user")
@Data
public class ScaUser extends Model<ScaUser> {

    @TableId(value="id", type= IdType.AUTO)
    private Long id;


    @TableField("user_name")
    private String userName;

    @TableField("user_label")
    private String userLabel;

    @TableField("user_password")
    private String userPassword;

    @TableField("salt")
    private String salt;

    @TableField("user_type")
    private String userType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    private int status;

}
