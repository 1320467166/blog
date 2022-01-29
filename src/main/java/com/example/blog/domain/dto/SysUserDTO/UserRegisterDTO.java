package com.example.blog.domain.dto.SysUserDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegisterDTO {
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

    @ApiModelProperty(name = "用户角色",notes = "用户角色")
    private String role;

    @ApiModelProperty(name = "头像",notes = "头像")
    private String avatar;

    @ApiModelProperty(name = "电话号码",notes = "电话号码")
    @NotBlank(message = "电话号码不可为空")
    @Size(max = 11,message = "电话号码最多支持11位数")
    private String phone;
}
