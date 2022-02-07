package com.example.blog.domain.dto.sysUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserForgetDTO {
    @ApiModelProperty(name = "用户名",notes = "用户名 不可为空")
    @NotBlank(message = "用户名不可为空")
    private String userName;

    @ApiModelProperty(name = "要修改的密码",notes = "要修改的密码")
    @NotBlank(message = "密码不可为空")
    private String password;

    @ApiModelProperty(name = "电话号码",notes = "电话号码")
    @NotBlank(message = "电话号码不可为空")
    @Size(max = 11,message = "电话号码最多支持11位")
    private String phone;
}
