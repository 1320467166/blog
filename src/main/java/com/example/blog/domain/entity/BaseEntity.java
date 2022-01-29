package com.example.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Id",example = "0")
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    @NotBlank(message = "id不可为空")
    private String id;

    @ApiModelProperty(value = "创建人",name = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty(value = "创建日期",name = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新人",name = "更新人")
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    @ApiModelProperty(value = "更新日期",name = "更新日期")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @TableLogic
    @TableField(value = "delete_flag")
    private int deleteFlag;
}
