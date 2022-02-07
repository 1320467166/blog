package com.example.blog.domain.dto.email;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailDTO {
    @ApiModelProperty(name = "邮箱地址",notes = "邮箱地址")
    @NotNull(message = "邮箱不可为空")
    private String[] email;
}
