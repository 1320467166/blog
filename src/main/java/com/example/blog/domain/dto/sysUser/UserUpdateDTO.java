package com.example.blog.domain.dto.sysUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserUpdateDTO {

    @ApiModelProperty(name = "id",notes = "id")
    @NotEmpty(message = "id不可为空")
    private String id;

    @ApiModelProperty(name = "昵称",notes = "昵称")
    private String nickName;

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
