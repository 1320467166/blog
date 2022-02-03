package com.example.blog.domain.entity;

import lombok.Data;

@Data
public class CmsArticle extends BaseEntity{
    private String catalogId;
    private String authorId;
    private String status;
    private String title;
    private String content;
    private Integer start;
    private Integer view_count;
    private String top;
}
