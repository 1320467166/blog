package com.example.blog.domain.dto;

import com.example.blog.domain.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class IdDTO extends BaseEntity {
    @ApiModelProperty(name = "id",notes = "id")
    private String id;

    @ApiModelProperty(name = "id列表",notes = "id列表,批量删除时使用")
    private String idList;
}
