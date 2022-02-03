package com.example.blog.mapper;

import com.example.blog.domain.entity.CmsArticle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsArticleMapper {
    List<CmsArticle> findCmsArticleList();
}
