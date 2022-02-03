package com.example.blog.domain.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CmsStar extends BaseEntity {
    @ApiModelProperty(value = "文章记录id",notes = "文章记录id")
    private String articleId;
}
