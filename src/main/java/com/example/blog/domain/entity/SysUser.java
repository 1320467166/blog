package com.example.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@TableName("sys_user")
public class SysUser extends BaseEntity{
    @ApiModelProperty(name = "用户名",notes = "用户名 不可为空")
    @NotBlank(message = "用户名不可为空")
    private String userName;

    @ApiModelProperty(name = "昵称",notes = "昵称")
    private String nickName;

    @ApiModelProperty(name = "密码",notes = "密码")
    @NotBlank(message = "密码不可为空")
    private String password;

    @ApiModelProperty(name = "性别",notes = "性别")
    private String sex;

    @ApiModelProperty(name = "用户地址",notes = "用户地址")
    private String address;

    @ApiModelProperty(name = "用户权限",notes = "用户权限")
    private String role;

    @ApiModelProperty(name = "头像",notes = "头像")
    private String avatar;

    @ApiModelProperty(name = "电话号码",notes = "电话号码")
    private String phone;

    @ApiModelProperty(name = "状态",notes = "状态")
    private String status;
}
